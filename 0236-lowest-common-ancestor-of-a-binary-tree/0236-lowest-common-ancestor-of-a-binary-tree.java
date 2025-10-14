/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left_found = lowestCommonAncestor(root.left, p, q);
        TreeNode right_found = lowestCommonAncestor(root.right, p, q);
        if(left_found != null && right_found != null) return root;
        if(left_found != null) return left_found;
        return right_found;
    }
}