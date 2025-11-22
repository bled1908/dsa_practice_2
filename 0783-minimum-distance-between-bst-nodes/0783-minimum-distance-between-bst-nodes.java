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
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(arr,root);
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++){
            int diff = Math.abs(arr.get(i) - arr.get(i+1));
            if(diff < mini){
                mini = diff;
            }
        }
        return mini;
    }
    public static void inorder(ArrayList<Integer>arr,TreeNode root){
        if(root == null){
            return;
        }
        inorder(arr,root.left);
        arr.add(root.val);
        inorder(arr,root.right);
    }
}