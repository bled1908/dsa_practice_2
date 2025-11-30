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

    private boolean helper(TreeNode root, int val){
        if(root == null) return true;

        if(root.left != null ){
           if(root.left.val == val){
                if(!helper(root.left,val)) return false;
            }
           else return false;
        }

        if(root.right != null)
        {
            if(root.right.val == val){
                 if(!helper(root.right,val)) return false;
            } else return false;
        }
        return true;
    }

    public boolean isUnivalTree(TreeNode root) {
        return helper(root,root.val);
    }
}