class Solution {
    public int findPairs(int[] nums, int k) {
        int left = 0, right = 1;
        int uniquePairs = 0;
        int n = nums.length;
        Arrays.sort(nums);
        while(left < n && right < n) {
            if(left == right) {
                right++;
                continue;
            }
            int diff = nums[right] - nums[left];
            if(diff == k) {
                uniquePairs++;
                left++;
                while(left < n && nums[left] == nums[left - 1]) 
                    left++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }
        return uniquePairs;

    }
}