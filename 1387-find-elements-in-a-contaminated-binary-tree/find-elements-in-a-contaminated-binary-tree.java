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
class FindElements {
    HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        set.add(0);
        helper(root);
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            set.add(root.left.val);
            helper(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            set.add(root.right.val);
            helper(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */