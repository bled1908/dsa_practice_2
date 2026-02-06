import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        // Step 1: Sorting is crucial to use the sliding window
        Arrays.sort(nums);

        int left = 0;
        int maxKept = 0;

        // Step 2: Sliding window to find the longest valid range
        for (int right = 0; right < n; right++) {
            // Check the balance condition: max <= k * min
            // Use long to prevent overflow if nums[i] * k exceeds Integer.MAX_VALUE
            while ((long) nums[left] * k < nums[right]) {
                left++;
            }
            // Length of current balanced window
            maxKept = Math.max(maxKept, right - left + 1);
        }

        return n - maxKept;
    }
}