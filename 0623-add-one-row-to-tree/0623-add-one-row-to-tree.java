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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int d = 1;
    

        while(!q.isEmpty()){
            int size = q.size();
            if(d == depth - 1){
                for(int i = 0; i < size; i ++){
                    TreeNode node = q.poll();
                    TreeNode newleft = new TreeNode(val);
                    TreeNode newright = new TreeNode(val);
                    if(node.left != null){
                        newleft.left = node.left;
                    }
                    if(node.right != null){
                        newright.right = node.right;
                    }

                    node.left = newleft;
                    node.right = newright;
                }
                return root;

            }else{
                for(int i = 0; i < size; i ++){
                    TreeNode node = q.poll();
                    if(node.left != null)q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
            d ++;
        }
        return root;
    }
}