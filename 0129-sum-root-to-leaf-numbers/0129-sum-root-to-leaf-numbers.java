class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        method(root,sum);
        return sum;
    }

    public void method(TreeNode node,int curr){
        if(node==null) return;

        curr = curr*10 + node.val;
        if(node.left==null && node.right==null){
            sum += curr;
        }

        method(node.left,curr);
        method(node.right,curr); 
    }
}