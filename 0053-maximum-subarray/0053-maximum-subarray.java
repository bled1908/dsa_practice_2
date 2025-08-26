class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int curr_sum = nums[0];
        int start = 0, end = 0, s = 0; //s -> temporary start
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > curr_sum + nums[i]) {
                curr_sum = nums[i];
                s = i;
            } else {
                curr_sum += nums[i];
            }
            if(curr_sum > max_sum) {
                max_sum = curr_sum;
                start = s;
                end = i;
            }
        }
        System.out.print("Max Sum: " + max_sum + ", Subarray: ");
        for(int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return max_sum;
    }
}