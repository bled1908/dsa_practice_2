class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> combination, int[] candidates, int rem, int start) {
        if(rem == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        if(rem < 0) return;
        for(int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(res, combination, candidates, rem - candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}