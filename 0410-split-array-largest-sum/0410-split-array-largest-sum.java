class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int n : nums) {
            low = Math.max(low, n); 
            high += n;              
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;          
                high = mid - 1;     
            } else {
                low = mid + 1;      
            }
        }

        return ans;
    }

    private boolean canSplit(int[] nums, int k, int maxSumAllowed) {
        int subarrays = 1;
        int currentSum = 0;

        for (int n : nums) {
            if (currentSum + n > maxSumAllowed) {
                subarrays++;        
                currentSum = n;

                if (subarrays > k) return false;
            } else {
                currentSum += n;
            }
        }

        return true;
    }
}