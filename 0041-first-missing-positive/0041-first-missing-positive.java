class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            int correctIndex = nums[i] - 1;
            if(nums[i] > 0 && nums[i] < n && nums[i] != nums[correctIndex]) 
                swap(nums, i, correctIndex);
            else i++;
        }
        for(int j = 0; j < n; j++) {
            if(nums[j] != j + 1) return j + 1;
        }
        return n + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}