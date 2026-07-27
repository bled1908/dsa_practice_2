import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        
        // Step 1: Sort the array to enable two-pointer logic
        Arrays.sort(nums);
        
        int left = 0;
        int right = 1;
        int uniquePairs = 0;
        int n = nums.length;
        
        // Step 2: Caterpillar movement across the sorted array
        while (left < n && right < n) {
            // Pointers cannot be the same. A pair requires two distinct elements.
            if (left == right) {
                right++;
                continue;
            }
            
            int diff = nums[right] - nums[left];
            
            if (diff == k) {
                // Found a valid unique pair
                uniquePairs++;
                left++;
                
                // Skip duplicates for the 'left' pointer to guarantee unique pairs
                while (left < n && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (diff < k) {
                // Difference is too small, expand the window by moving right
                right++;
            } else {
                // Difference is too large, shrink the window by moving left
                left++;
            }
        }
        
        return uniquePairs;
    }
}