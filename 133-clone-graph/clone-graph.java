/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> mp = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        mp.clear();
        Node clone = new Node(node.val);
        mp.put(node, clone);
        dfs(node, clone);
        return clone;
    }

    public void dfs(Node node, Node cloneNode) {
        for (Node n : node.neighbors) {
            if (!mp.containsKey(n)) {
                Node clone = new Node(n.val);
                mp.put(n, clone);
                cloneNode.neighbors.add(clone);
                dfs(n, clone);
            } else {
                cloneNode.neighbors.add(mp.get(n));
            }
        }
    }
}