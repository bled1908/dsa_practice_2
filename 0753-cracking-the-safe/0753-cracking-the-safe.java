class Solution {
    public String crackSafe(int n, int k) {
        int numCombinations = (int) Math.pow(k, n);
        boolean[] visited = new boolean[numCombinations];
        
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sequence.append("0");
        }
        visited[0] = true;
        visit(n, k, 0, visited, sequence);
        
        return sequence.toString();
    }
    
    private static boolean visit(int n,
                                 int k,
                                 int combination,
                                 boolean[] visited,
                                 StringBuilder sequence) {
        int numCombinations = visited.length;
        if (sequence.length() == numCombinations + n - 1) {
            return true;
        }
        
        int combinationBase = combination * k % numCombinations;
        for (int i = 0; i < k; i++) {
            int newCombination = combinationBase + i;
            if (!visited[newCombination]) {
                sequence.append((char) (i + '0'));
                visited[newCombination] = true;
                if (visit(n, k, newCombination, visited, sequence)) {
                    return true;
                }
                visited[newCombination] = false;
                sequence.setLength(sequence.length() - 1);
            }
        }
        
        return false;
    }
}