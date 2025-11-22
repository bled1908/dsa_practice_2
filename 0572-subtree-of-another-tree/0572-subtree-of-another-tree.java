/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // Main function to check if subRoot is a subtree of root.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If the main tree is null, no subtree can exist.
        if (root == null) {
            return false;
        }

        // Check if the tree starting at the current root is identical to subRoot.
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // If not, recursively check the left and right subtrees.
        // A match in either subtree is sufficient.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper function to check if two trees are identical in structure and value.
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are considered the same.
        if (p == null && q == null) {
            return true;
        }

        // If one node is null but the other isn't, or their values differ,
        // they are not the same.
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Recursively check if both the left and right subtrees are also identical.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}