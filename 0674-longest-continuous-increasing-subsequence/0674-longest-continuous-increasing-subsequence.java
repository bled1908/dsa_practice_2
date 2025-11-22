class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=0;
        int count=1;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>prev){
                count++;
                prev=nums[i];
            }
            else{
                ans=Math.max(ans,count);
                count=1;
                prev = nums[i];
            }
        }
        return Math.max(ans,count);
    }
}