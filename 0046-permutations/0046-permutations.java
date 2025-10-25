class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), used, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPermutation, boolean[] used, int[] nums) {
        // Base Case: If our currentPermutation is the same size as our input array
        // It means we have a complete valid permutation
        if(currentPermutation.size() == nums.length) {
            // Add a new *new copy of the current permutation to the results
            // if we add 'currentPermutation' directly, it will be emptied by backtracking
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        // Recursive step: Try every number
        for(int i = 0; i < nums.length; i++) {
            // we will only consider this number if we haven't used this in our path
            if(!used[i]) {
                // 1. Add the number and mark it as used
                currentPermutation.add(nums[i]);
                used[i] = true;

                // 2. Explore: Recurse to build the rest of the permutation
                backtrack(result, currentPermutation, used, nums);

                // 3. Unchoose (Backtrack): Remove the number and mark it
                // This allows the next iteration of the loop to try a different number in this same position
                used[i] = false;
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}