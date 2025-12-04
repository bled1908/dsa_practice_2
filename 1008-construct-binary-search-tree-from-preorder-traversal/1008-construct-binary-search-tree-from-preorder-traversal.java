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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int[] i, int upperBound) {
        if (i[0] == preorder.length || preorder[i[0]] > upperBound) return null;

        TreeNode node = new TreeNode(preorder[i[0]++]);
        node.left = bstFromPreorder(preorder, i, node.val);
        node.right = bstFromPreorder(preorder, i, upperBound);
        return node;
    }
}