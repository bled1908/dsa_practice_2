class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int curr_sum = 0;
        for(int n: nums) {
            curr_sum += n;
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
            }
            if(curr_sum < 0) {
                curr_sum = 0;
            }
        }
        return max_sum;
    }
}