class Solution {

    public void nextPermutation(int[] nums) {

        int index = -1;

        // Step 1: Find the first decreasing element from the end
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no such element exists, reverse the whole array
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 3: Find the next greater element and swap
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 4: Reverse the remaining part
        reverse(nums, index + 1, nums.length - 1);
    }

    // Reverse the array from left to right
    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    // Swap two elements
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}