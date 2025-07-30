class LRUCache {
    final int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        // Node head;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            // this.head=null;
            this.prev = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            updateNode(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            addNode(newNode);
            if (map.size() > capacity) {
                Node tailNode = removeTail();
                map.remove(tailNode.key);
            }
        }
    }

    public void updateNode(Node node) {
        removeNode(node);
        addNode(node);
    }

    public void addNode(Node node) {
        Node temp = head.next;
        node.prev = head;
        node.next=temp;
        temp.prev=node;
        head.next=node;
    }

    public void removeNode(Node node) {
        Node preNode = node.prev;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.prev = preNode;
    }

    public Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */