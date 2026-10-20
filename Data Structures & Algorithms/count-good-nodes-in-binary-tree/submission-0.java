/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        int good = 0;
        if (max <= root.val) {
            good = 1;
        }
        if (root.left != null && root.right != null) {
            return good + dfs(root.left, Math.max(root.val, max)) + dfs(root.right, Math.max(root.val, max));
        } else if (root.left != null && root.right == null) {
            return good + dfs(root.left, Math.max(root.val, max));
        } else if (root.left == null && root.right != null) {
            return good + dfs(root.right, Math.max(root.val, max));
        } else {
            return good;
        }
    }
}
