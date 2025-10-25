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
    private void dfs(TreeNode root, int targetSum, int currSum) {
        if(root == null) {
            return;
        }
        currSum += root.val;
        if(currSum == targetSum) count += 1;
        dfs(root.left, targetSum, currSum);
        dfs(root.right, targetSum, currSum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        dfs(root, targetSum, 0);
        dfs(root.left, targetSum, 0);
        dfs(root.right, targetSum, 0);
        return (int) count;
    }
}