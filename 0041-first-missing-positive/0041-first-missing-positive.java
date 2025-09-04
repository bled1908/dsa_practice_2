class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n) {
            int corr_idx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < n && nums[i] != nums[corr_idx]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for(i = 0; i < n; i++) {
            if(nums[i] != i + 1) return (i + 1);
        }
        return n + 1;
    }
}