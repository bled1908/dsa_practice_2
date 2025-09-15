class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        if(nums[low] == nums[mid]) {
            return nums[low];
        } else {
            return nums[mid];
        }
    }
}