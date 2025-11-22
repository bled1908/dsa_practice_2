class Solution {
    int sum = 0; // Cumulative sum of greater nodes

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;

        // 1. Go right first (largest values first)
        traverse(node.right);

        // 2. Process current node
        sum += node.val;
        node.val = sum;

        // 3. Go left
        traverse(node.left);
    }
}