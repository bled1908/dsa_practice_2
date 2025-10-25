class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results  = new ArrayList<>();
        backtrack(0, nums, results);
        return results;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> results) {
        // If the index has reached the end of the array, we have a complete permutation
        if(index == nums.length) {
            results.add(toList(nums));
            return;
        }

        // Recursive step: Iterate from the current index to the end
        for (int i = index; i < nums.length; i++) {
            // Choose: Swap the current element (nums[i]) with the element at the index position
            swap(nums, index, i);

            // Explore: Recurse to fill the next position
            backtrack(index + 1, nums, results);

            // Un-choose(Backtrack): Swap the elements back to restore the original array state for teh next iteration of the loop
            swap(nums, index, i);
        }
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}