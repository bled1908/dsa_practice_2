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
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root, p, path1);
        findPath(root, q, path2);
        int i = 0;
        TreeNode lca = null;
        while(i < path1.size() && i < path2.size()) {
            if(path1.get(i) == path2.get(i)) lca = path1.get(i);
            else break;
            i++;
        }
        return lca;
    }

    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if(root == null) return false;
        path.add(root);
        if(root == target) return true;

        if(findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}