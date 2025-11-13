class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;
        while(pivot >= 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
        if(pivot >= 0) {
            int successor = nums.length - 1;
            while(nums[successor] <= nums[pivot]) successor--;
            swap(nums, pivot, successor);
        }
        reverse(nums, pivot + 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}