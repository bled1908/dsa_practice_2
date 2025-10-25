class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> curCom, int n, int k, int start) {
        // Base Case: We have a complete combination of size k
        if(curCom.size() == k) {
            res.add(new ArrayList<>(curCom));
            return;
        }

        // Recursive step: We explore all valid choices
        // we only choose numbers from 'start' to 'n'
        for(int i = start; i <= n; i++) {
            // Choose: Add the number 'i'
            curCom.add(i);
            
            // Explore: Recurse to find the rest of teh combination, the next call must start from i + 1, to avoid duplicates.
            backtrack(res, curCom, n, k , i + 1);

            // Unchoose (Backtrack): Remove 'i' to explore other paths
            curCom.remove(curCom.size() - 1);
        }
    }
}