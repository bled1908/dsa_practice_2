class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int maxRealityA = robSimple(nums, 0, n - 2);
        int maxRealityB = robSimple(nums, 1, n - 1);
        return Math.max(maxRealityA, maxRealityB);
    }
    private int robSimple(int[] nums, int a, int b) {
        int prev2 = 0, prev1 = 0;
        for(int i = a; i <= b; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;

    }
}