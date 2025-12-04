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
    int sum=0;
    void dfs(TreeNode root,int curr){
        if(root==null) return;
        curr=2*curr+root.val;
        if(root.left==null&&root.right==null) sum+=curr;
        dfs(root.left,curr);
        dfs(root.right,curr);
    }
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return sum;
    }
}