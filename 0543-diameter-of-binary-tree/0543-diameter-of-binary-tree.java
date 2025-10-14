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
    private int max_diam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max_diam;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        int curr_diam = left_height + right_height;
        max_diam = Math.max(max_diam, curr_diam);
        return 1 + Math.max(left_height, right_height);
    }
}