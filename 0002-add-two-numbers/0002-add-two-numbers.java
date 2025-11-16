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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;
        ListNode res = new ListNode(-1);
        ListNode dummy = res;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int finalSum = sum % 10;
            carry = sum / 10;
            dummy.next = new ListNode(finalSum);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int sum = l1.val + carry;
            int finalSum = sum % 10;
            carry = sum / 10;
            dummy.next = new ListNode(finalSum);
            dummy = dummy.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int sum = l2.val + carry;
            int finalSum = sum % 10;
            carry = sum / 10;
            dummy.next = new ListNode(finalSum);
            dummy = dummy.next;
            l2 = l2.next;
        }
        if(carry != 0) dummy.next = new ListNode(carry);
        return res.next;
    }
}