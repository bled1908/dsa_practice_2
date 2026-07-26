class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode start = head;
        ListNode mover = head;
        ListNode hold = head;  

        while (mover.next != null) {
            if (mover.next != null && mover.val == mover.next.val)mover = mover.next;  
            else {
                if (head.val == head.next.val) {
                    mover = mover.next;
                    head = mover;
                    start = head;
                    hold = head;
                } 
                else {
                    if (start != mover) {
                        mover = mover.next;
                        hold.next = mover;
                        start = mover;
                    } 
                    else {
                        mover = mover.next;
                        hold = start;
                        start.next = mover;
                        start = mover;
                    }
                }
            }
        }
        if(head.next==null)return head;  
        if(head==start)return null;
        if(hold.next.next!=null)hold.next=null;
        return head;
    }
}




// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if (head == null) return null;

//         ListNode start = head;
//         ListNode mover = head;
//         ListNode hold = head;  

//         while (mover.next != null) {
//             if (mover.next != null && mover.val == mover.next.val)mover = mover.next;  
//             else {
//                 if (head.val == head.next.val) {
//                     mover = mover.next;
//                     head = mover;
//                     start = head;
//                     hold = head;
//                 } 
//                 else {
//                     if (start != mover) {
//                         mover = mover.next;
//                         hold.next = mover;
//                         start = mover;
//                     } 
//                     else {
//                         mover = mover.next;
//                         hold = start;
//                         start.next = mover;
//                         start = mover;
//                     }
//                 }
//             }
//         }

//         mover = head;
//         start=head;

//         while(start.next!=null)start=start.next;
//         if(head.next==null)return head;         //For[2]                       _____->this will be removed up.
//         if(mover.val==start.val)return null;   //For cases like --> [1,1,1] , [1,1,1,2,2,2] ,[2,2]
//         while(mover.next.val!=start.val)mover=mover.next;
//         if(mover.next!=start)mover.next=null;
//         return head;
//     }
// }
