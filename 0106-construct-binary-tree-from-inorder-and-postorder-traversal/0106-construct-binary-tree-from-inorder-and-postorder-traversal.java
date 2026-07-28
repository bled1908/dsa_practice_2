class Solution {
    int postIndex;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        
        // store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;

        // pick root from postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // find index in inorder
        int index = map.get(rootVal);

        // IMPORTANT: build right first
        root.right = helper(inorder, postorder, index + 1, right);
        root.left  = helper(inorder, postorder, left, index - 1);

        return root;
    }
}