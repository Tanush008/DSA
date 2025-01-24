class LFUCache {
   final int capacity;
    int curSize;
    int minfreq;
    Map<Integer, Node> map;
    Map<Integer, DLL> freqMap;

    class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.freq = 1;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minfreq = 0;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
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
        if(capacity==0){
            return;
        }
        if(map.containsKey(key)){
            Node currNode = map.get(key);
            currNode.val = value;
            updateNode(currNode);
        }
        else{
                curSize++;
                if(curSize>capacity){
                    DLL minFreqList = freqMap.get(minfreq);
                    map.remove(minFreqList.tail.prev.key);
                    minFreqList.delete(minFreqList.tail.prev);
                    curSize--;
                }
                minfreq = 1;
                Node newNode=new Node(key,value);
                DLL currList = freqMap.getOrDefault(1,new DLL());
                currList.add(newNode);
                freqMap.put(1,currList);
                map.put(key,newNode);
        }
    }

    public void updateNode(Node currNode) {
        int curFreq = currNode.freq;
        DLL currList = freqMap.get(curFreq);
        currList.delete(currNode);
        if (curFreq == minfreq && currList.listSize == 0) {
            minfreq++;
        }
        currNode.freq++;
        DLL newList = freqMap.getOrDefault(currNode.freq, new DLL());
        newList.add(currNode);
        freqMap.put(currNode.freq, newList);
    }

    class DLL {
        int listSize;
        Node head;
        Node tail;

        DLL() {
            this.listSize = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            Node nextNode = head.next;
            node.next = nextNode;
            node.prev = head;
            head.next = node;
            nextNode.prev = node;
            listSize++;
        }

        public void delete(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */