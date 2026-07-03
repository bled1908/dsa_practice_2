class Solution {
    private void fun(int[] candidates, int remaining, int ptr, List<Integer> curr, List<List<Integer>> res) {
        // Base Case: Target sum achieved perfectly
        if(remaining == 0) {
            res.add(new ArrayList<>(curr)); // Shallow copy snapshot
            return;
        }
        
        for(int poss = ptr; poss < candidates.length; poss++){
            // 1. Early Break: Since it's sorted, all upcoming elements are too large
            if(candidates[poss] > remaining) break;
            
            // 2. Duplicate Pruning: Skip duplicate choices at the exact same tree level
            if(poss > ptr && candidates[poss] == candidates[poss - 1]) continue;
            
            curr.add(candidates[poss]);
            
            // Recurse forward to poss + 1 to prevent reuse of the same array element
            fun(candidates, remaining - candidates[poss], poss + 1, curr, res);
            
            curr.remove(curr.size() - 1); // Backtrack state
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Critical step for both pruning rules to function
        List<List<Integer>> res = new ArrayList<>();
        fun(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
}