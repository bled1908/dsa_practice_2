class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0; // current streak
        int co = 0;  // longest streak
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max++;
            } else {
                max = 0;
            }
            if (max > co) co = max;
        }
        return co;
    }
}