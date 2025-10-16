class Solution {
    int R;
    int C;

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        R = grid.length;
        C = grid[0].length;
        int islandCount = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == '1') {
                    islandCount++;
                    sinkIsland(grid, r, c);
                }
            }
        }
        return islandCount;
    }

    private void sinkIsland(char[][] grid, int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '0') return;
        grid[r][c] = '0';
        sinkIsland(grid, r - 1, c); 
        sinkIsland(grid, r + 1, c); 
        sinkIsland(grid, r, c - 1); 
        sinkIsland(grid, r, c + 1); 
    }
}