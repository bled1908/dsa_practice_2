import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        // 🔹 Step 1: Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 🔹 Step 2: Build the graph (y → x means y is poorer than x)
        for (int[] rich : richer) {
            graph[rich[1]].add(rich[0]);
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // -1 means unprocessed
        
        // 🔹 Step 3: DFS to find the quietest person for each node
        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                dfs(graph, i, quiet, ans);
            }
        }
        
        return ans;
    }
    
    private int dfs(ArrayList<Integer>[] graph, int node, int[] quiet, int[] ans) {
        if (ans[node] != -1) {
            return ans[node]; // Return memoized result
        }
        
        int min = node; // Start with current person
        
        for (int next : graph[node]) {
            int cur = dfs(graph, next, quiet, ans); // Recursive DFS
            
            // 🔍 If a quieter person is found, update `min`
            if (quiet[cur] < quiet[min]) {
                min = cur;
            }
        }
        
        ans[node] = min; // Store the result for memoization
        return min;
    }
}