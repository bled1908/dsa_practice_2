/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node curNode = queue.remove();
                for(Node child: curNode.children){
                    queue.add(child);
                }
                temp.add(curNode.val);
            }
            results.add(temp);            
        }
        return results;
    }
}