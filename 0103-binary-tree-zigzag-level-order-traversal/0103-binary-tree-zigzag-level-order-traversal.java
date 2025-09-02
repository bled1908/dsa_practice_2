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
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        for(int i = 0; i < result.size(); i++) {
            if ((i & 1) == 1) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if(node.left != null) dfs(node.left, level + 1, result);
        if(node.right != null) dfs(node.right, level + 1, result);
    }
}