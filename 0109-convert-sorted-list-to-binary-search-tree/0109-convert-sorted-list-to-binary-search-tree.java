/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    TreeNode maketree(ListNode st,ListNode end){//end node is exclusive here******Bold******
        if(st==null||st==end)return null;
        if(st.next==end){return new TreeNode(st.val);}
        ListNode slow=st,fast=st;
        while(fast!=end&&fast.next!=end){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode curr=new TreeNode(slow.val);
        curr.left=maketree(st,slow);
        curr.right =maketree(slow.next,end);
        return curr;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return maketree(head,null);
    }
}