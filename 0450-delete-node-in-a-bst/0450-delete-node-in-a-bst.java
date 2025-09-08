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
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }

    private TreeNode dfs(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) root.left = dfs(root.left, key);
        else if(root.val < key) root.right = dfs(root.right, key);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = dfs(root.right, successor.val);
        } 
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) return null;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}