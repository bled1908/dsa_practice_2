class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, used, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> curPer) {
        // Base case: If our length of curPer == nums.length, then we have found a valid permutation
        if(curPer.size() == nums.length) {
            res.add(new ArrayList<>(curPer));
            return;
        }

        // Recursive step, that is visiting every element of nums
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;
            if(!used[i]) {
                // Choose the element
                curPer.add(nums[i]);
                used[i] = true;

                // Exploaration to fill the remaining path
                backtrack(nums, res, used, curPer);

                // Un-choose (backtrack)
                used[i] = false;
                curPer.remove(curPer.size() - 1);
            }
        }
    }
}