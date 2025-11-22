class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int i=nums.length-1;
        int last=nums[nums.length-1];
        int[] arr=new int[nums.length];
        int max=Integer.MIN_VALUE;
        int count=1;
        while(i>=0 )
        {
            if(nums[i]==max && count==0)
            {
                return arr;
            }
            max=Math.max(nums[i],max);
            if(st.isEmpty())
            {
                st.push(nums[i]);
                arr[i]=-1;
            }
            else{

                if(nums[i]<st.peek())
                {
                    int temp=st.peek();
                    st.push(nums[i]);
                    arr[i]=temp;
                }
                else{
                    while(!st.isEmpty() && nums[i]>=st.peek())
                    {
                        st.pop();
                    }
                    if(st.isEmpty())
                    {
                        st.push(nums[i]);
                        arr[i]=-1;
                    }
                    else{
                        int temp=st.peek();
                        st.push(nums[i]);
                       arr[i]=temp;
                    }
                }
            }
            i--;
            if(i==-1)
            {
                count--;
                i=nums.length-1;
            }
        }
        
        return arr;
    }
}