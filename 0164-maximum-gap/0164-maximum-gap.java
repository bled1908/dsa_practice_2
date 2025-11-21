class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2) return 0;
        Arrays.sort(nums);
        int maxdiff=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            maxdiff=Math.max(maxdiff,Math.abs(nums[i]-nums[i+1]));
        }
        return maxdiff;
    }
}