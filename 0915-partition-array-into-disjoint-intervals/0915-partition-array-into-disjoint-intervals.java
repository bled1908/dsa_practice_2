class Solution {
    public int partitionDisjoint(int[] nums) {
        int ans=1;
        int currMax=nums[0];
        int maxCanBe=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<currMax){
                ans=i+1;
                currMax=maxCanBe;
            }
            else{
                maxCanBe=Math.max(maxCanBe,nums[i]);
            }
        }
        return ans;
    }
}