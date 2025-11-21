class BSTIterator {
    Stack<TreeNode> st = new Stack<>(); // stack to store nodes
    
    public BSTIterator(TreeNode root) {
        // initialize stack with the left chain of root
        pushLeftChain(root);
    }
    
    public int next() {
        // get the next smallest node
        TreeNode node = st.pop();
        
        // if node has a right child, push its left chain
        if (node.right != null) {
            pushLeftChain(node.right);
        }
        
        return node.val; // return value
    }
    
    public boolean hasNext() {
        // still nodes left if stack is not empty
        return !st.isEmpty();
    }
    
    private void pushLeftChain(TreeNode node) {
        // push all left children into stack
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}