class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        // for(int i = 0; i < v; i++) {
        //     System.out.println(adj.get(i));
        // }
        int count = 0;
        boolean[] vis = new boolean[v];
        for(int i = 0; i < v; i++) {
            if(!vis[i]) {
                count++;
                dfs(i, adj, vis);
            }
        }
        return count;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] vis) {
        vis[u] = true;
        for(int v: adj.get(u)) {
            if(!vis[v]) dfs(v, adj, vis);
        }
    }
}