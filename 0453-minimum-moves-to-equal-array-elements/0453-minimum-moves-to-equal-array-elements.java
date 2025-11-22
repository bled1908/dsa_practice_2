class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int sum=0;
        int minValue=Arrays.stream(nums).min().getAsInt();
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return sum-n*minValue;
    }
}