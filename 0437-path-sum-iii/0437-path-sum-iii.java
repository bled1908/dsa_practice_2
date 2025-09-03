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
    long count = 0;

    private void dfs(TreeNode node, long curr_sum, int targetSum) {
        if(node == null) return;
        curr_sum += node.val;
        if(curr_sum == targetSum) count += 1;
        dfs(node.left, curr_sum, targetSum);
        dfs(node.right, curr_sum, targetSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        dfs(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return (int) count;
    }
}