class Solution {
    List<Integer> inorder = new ArrayList<>();

    private void inorderCreation(TreeNode root) {
        if (root == null) return;
        inorderCreation(root.left);
        inorder.add(root.val);
        inorderCreation(root.right);
    }

    private boolean twoPointerSearch(List<Integer> list, int k) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            else if (sum > k) j--;
            else i++;
        }
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        inorderCreation(root);
        return twoPointerSearch(inorder, k);
    }
}