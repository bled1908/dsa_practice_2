/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node clonedStartNode = new Node(node.val);
        oldToNew.put(node, clonedStartNode);
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node originalNode = queue.poll();
            Node clonedNode = oldToNew.get(originalNode);
            for(Node originalNeighbor: originalNode.neighbors) {
                if(!oldToNew.containsKey(originalNeighbor)) {
                    Node clonedNeighbor = new Node(originalNeighbor.val);
                    oldToNew.put(originalNeighbor, clonedNeighbor);
                    queue.offer(originalNeighbor);
                }
                clonedNode.neighbors.add(oldToNew.get(originalNeighbor));
            }
        }
        return clonedStartNode;
    }
}