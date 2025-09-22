class Solution {
    public int numIslands(char[][] grid) {
        // DFS implementation
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int numRows = grid.length;
        int numCols = grid[0].length;
        int count = 0;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int u, int v) {
        if(u < 0 || u >= grid.length || v < 0 || v >= grid[0].length || grid[u][v] == '0') {
            return;
        }
        grid[u][v] = '0';
        dfs(grid, u + 1, v);
        dfs(grid, u - 1, v);
        dfs(grid, u, v + 1);
        dfs(grid, u, v - 1);
    }
}