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
    public int sumNumbers(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        int sum = 0;
        for(String p: paths) {
            sum += Integer.parseInt(p);
        }
        return sum;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if(node == null) return;
        path += node.val;
        if(node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        dfs(node.left, path, paths);
        dfs(node.right, path, paths);
    }
}