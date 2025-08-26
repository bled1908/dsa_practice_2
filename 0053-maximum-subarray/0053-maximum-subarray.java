class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;

        int leftSum = maxSubArrayHelper(nums, left, mid);
        int rightSum = maxSubArrayHelper(nums, mid + 1, right);
        int crossSum = maxCrossingSum(nums, left, mid, right);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // Left Half (max suffix sum)
        int left_sum = Integer.MIN_VALUE;
        int total = 0;
        for(int i = mid; i >= left; i--) {
            total += nums[i];
            left_sum = Math.max(total, left_sum);
        } 

        // Right Half (max prefix sum)
        int right_sum = Integer.MIN_VALUE;
        total = 0;
        for(int i = mid + 1; i < right + 1; i++) {
            total += nums[i];
            right_sum = Math.max(right_sum, total);
        }

        return (left_sum + right_sum);
    }
}