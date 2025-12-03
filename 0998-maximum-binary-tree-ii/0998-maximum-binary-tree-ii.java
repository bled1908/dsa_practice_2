class Solution {
    TreeNode p;
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
 
        if( root == null){
            return new TreeNode(val);
        }
        
        if( root.val < val ){
            TreeNode node = new TreeNode(val);
            node.left = root;
            root = node;
            return node;
        }
        
        root.right = insertIntoMaxTree(root.right, val);
        
        return root;
        
    }
}