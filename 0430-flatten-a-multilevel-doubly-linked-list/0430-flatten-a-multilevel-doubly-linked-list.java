/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp=head;
        Stack<Node> stack=new Stack<>();

        while(temp!=null){
            if(temp.child!=null){
                if(temp.next!=null)stack.push(temp.next);
                temp.next=temp.child;
                temp.child=null;
                temp.next.prev=temp;
                temp=temp.next;
                continue;
            }
            if(!stack.isEmpty() && temp.next==null){
                Node node=stack.pop();
                temp.next=node;
                node.prev=temp;
            }
            
            temp=temp.next;
        }

        return head;
    }
}