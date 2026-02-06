class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int i = 0, maxWindow = 0;
        Arrays.sort(nums);
        for(int j = 0; j < n; j++) {
            while(nums[j] > (long) nums[i] * k) i++;
            maxWindow = Math.max(maxWindow, j - i + 1);
        }
        return n - maxWindow;
    }
}