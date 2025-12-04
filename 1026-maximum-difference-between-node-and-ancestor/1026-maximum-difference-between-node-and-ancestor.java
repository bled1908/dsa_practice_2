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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root).ans;
    }
    private Pair dfs(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return new Pair(root.val, root.val, 0);
        }
        Pair leftPair = dfs(root.left);
        Pair rightPair = dfs(root.right);
        Pair rootPair = new Pair(root.val, root.val, 0);
        if(leftPair != null){
            rootPair.max = Math.max(rootPair.max, leftPair.max);
            rootPair.min = Math.min(rootPair.min, leftPair.min);
            rootPair.ans = Math.max(rootPair.ans, leftPair.ans);
            rootPair.ans = Math.max(rootPair.ans, 
                                    Math.max(Math.abs(root.val - leftPair.min), 
                                                    Math.abs(root.val - leftPair.max)));
        }
        if(rightPair != null){
            rootPair.max = Math.max(rootPair.max, rightPair.max);
            rootPair.min = Math.min(rootPair.min, rightPair.min);
            rootPair.ans = Math.max(rootPair.ans, rightPair.ans);
            rootPair.ans = Math.max(rootPair.ans, 
                                    Math.max(Math.abs(root.val - rightPair.min), 
                                                    Math.abs(root.val - rightPair.max)));
        }
        return rootPair;
    }
    class Pair{
        int max;
        int min;
        int ans;
        public Pair(int max, int min, int ans){
            this.max = max;
            this.min = min;
            this.ans = ans;
        }
    } 
}