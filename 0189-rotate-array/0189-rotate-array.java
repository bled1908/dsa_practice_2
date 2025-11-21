class Solution {
    public void reverse(int[] nums, int l, int r){
        while(l<=r){
            // swap 
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        // nums = [1,2,3,4,5,6,7], k = 3

        // Remember these steps to rotate array (Aage bhi bahot kaam ayega)

        // 1. Reverse the arr
        reverse(nums, 0, nums.length-1); // [7,6,5,4,3,2,1]
        
        // 2. Reverse the arr from start to (start + k)
        reverse(nums, 0, k-1); // [5,6,7,4,3,2,1]

        // 3. Reverse from (start + k) to end
        reverse(nums, k, nums.length-1); // [5,6,7,1,2,3,4]
    }
}