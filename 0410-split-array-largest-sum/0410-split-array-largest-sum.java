class Solution {
    public int splitArray(int[] nums, int k) {
        if(k > nums.length) return -1;
        int low = 0, high = 0;
        for(int num: nums) {
            low = Math.max(low, num);
            high += num;
        }
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean canSplit(int[] nums, int k, int mid) {
        int n = 1;
        int curr = 0;
        for(int num: nums) {
            if(curr + num <= mid) {
                curr += num;
            } else {
                n++;
                curr = num;
                if(n > k) return false;
            }
        }
        return true;
    }
}