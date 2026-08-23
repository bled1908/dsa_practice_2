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

    private int helper(TreeNode root, int[] ans){
        if(root == null){
            return 0;
        }

        int leftPathSum = Math.max(0, helper(root.left, ans));
        int rightPathSum = Math.max(0, helper(root.right, ans));

        int totalPathSum = leftPathSum + rightPathSum + root.val;
        ans[0] = Math.max(ans[0], totalPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);
    }

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int[] ans = {Integer.MIN_VALUE};
        helper(root, ans);
        return ans[0];
    }
}