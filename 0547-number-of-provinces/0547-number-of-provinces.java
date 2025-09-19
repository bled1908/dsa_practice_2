class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[v];
        for(int i = 0; i < v; i++) {
            if(!vis[i]) {
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }

    private void dfs(int u, int[][] adj, boolean[] vis) {
        vis[u] = true;
        for(int v = 0; v < adj.length; v++) {
            if(!vis[v] && adj[u][v] == 1) dfs(v, adj, vis);
        }
    }
}