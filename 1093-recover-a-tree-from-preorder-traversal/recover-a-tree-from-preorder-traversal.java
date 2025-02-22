/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // int n = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> st = new Stack<>();
        int index = 0;
        int n = traversal.length();
        while (index < n) {
            int count = 0;
            while (index < n && !Character.isDigit(traversal.charAt(index))) {
                count++;
                index++;
            }
            int depth = st.size();
            while (count < depth) {
                st.pop();
                depth--;
            }
            int val = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))) {
                val = val * 10 + (traversal.charAt(index) - '0');
                index++;
            }
            TreeNode newNode = new TreeNode(val);
            if (!st.isEmpty()) {
                if (st.peek().left == null) {
                    st.peek().left = newNode;
                } else {
                    st.peek().right = newNode;
                }
            }
            st.push(newNode);
        }
        while (st.size() > 1) {
            st.pop();
        }
        return st.peek();
    }
}