class Solution {
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        solve(root1, list1);
        solve(root2, list2);
        
        return list1.equals(list2);
    }
    
    private void solve(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        
        solve(node.left, list);
        solve(node.right,list);
    }
}