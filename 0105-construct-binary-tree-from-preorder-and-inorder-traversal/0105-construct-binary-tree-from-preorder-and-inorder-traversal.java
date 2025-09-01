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
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        int inIndex = -1;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = build(preorder, inorder, inStart, inIndex - 1);
        root.right = build(preorder, inorder, inIndex + 1, inEnd);

        return root;
    }
}