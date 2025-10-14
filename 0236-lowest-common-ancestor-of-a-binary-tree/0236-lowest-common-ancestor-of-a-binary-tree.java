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
        ArrayList<TreeNode> path_p = new ArrayList<>();
        ArrayList<TreeNode> path_q = new ArrayList<>();
        getPath(root, p, path_p);
        getPath(root, q, path_q);
        int i = 0;
        TreeNode lca = null;
        while(i < path_p.size() && i < path_q.size() && path_p.get(i) == path_q.get(i)) {
            lca = path_p.get(i);
            i++;
        }
        return lca;
    }

    private boolean getPath(TreeNode root, TreeNode e, ArrayList path) {
        if(root == null) return false;
        path.add(root);
        if(root == e) return true;
        if(getPath(root.left, e, path) || getPath(root.right, e, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }
}