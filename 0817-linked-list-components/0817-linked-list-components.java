
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        ListNode temp=head;
        boolean present,con=false;
        int result=0;
        while(temp!=null)
        {
            present=false;
            int dat=temp.val;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==dat)
                {
                    present=true;
                    break;
                }
            }
            if(present && !con)
            {
                con=true;
                result++;
            }
            if(!present)
            {
                con=false;
            }
            temp=temp.next;
        }
        return result;
    }
}