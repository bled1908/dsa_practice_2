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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

     Queue<TreeNode> queue = new LinkedList<>();

    List<List<Integer>> list = new ArrayList<>();

    if(root==null) return new ArrayList<>();

    queue.offer(root);

boolean turn = false;
    while(!queue.isEmpty()){

List<Integer> ans = new ArrayList<>();
       
int s = queue.size();
        for(int i =0; i < s; i++) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                
                
                
            }
       
 
if(turn) Collections.reverse(ans);
   turn = !turn;       
     
        list.add(new ArrayList<>(ans));

    }


    return list;}
}