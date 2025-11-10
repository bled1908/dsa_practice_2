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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = head;
        ListNode prev = dummy;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) set.add(nums[i]);
        while(curr != null) {
            if(set.contains(curr.val)) {
                curr = curr.next;
                prev.next = curr;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}