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
    void solve( HashSet <Integer> arr,TreeNode root){
        if(root==null){
            return;
        }

        solve(arr,root.left);
        arr.add(root.val);  
        solve(arr,root.right);

    }
 
    public int findSecondMinimumValue(TreeNode root) {
        
        HashSet <Integer> arr=new  HashSet <>();
        solve(arr,root);
        ArrayList <Integer> set=new ArrayList<>(arr);
        Collections.sort(set);
        if(set.size()==1){
            return -1;
        }
        return set.get(1);



    
        
    }
}