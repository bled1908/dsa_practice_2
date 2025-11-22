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
    int ans=0;
    private int dfs(TreeNode root,int parentVal){
        if(root==null)return 0;
        int l=dfs(root.left,root.val);
        int r=dfs(root.right,root.val);
        ans=Math.max(ans,l+r);
        if(root.val==parentVal){
            return Math.max(l,r)+1;
        }else return 0;
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,-1);
        return ans;
    }
}