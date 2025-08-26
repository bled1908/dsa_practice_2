class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int sub_sum = 0;
            for(int j = i; j < n; j++) {
                sub_sum += nums[j];
                if (sub_sum == k) {
                    count += 1;
                }
            }
        }
        return count;
    }
}