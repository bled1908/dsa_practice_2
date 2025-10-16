class Solution {
    public int numIslands(char[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int islandCount = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(grid[r][c] == '1') {
                    islandCount++;
                    sinkIsland(grid, r, c, R, C);
                }
            }
        }
        return islandCount;
    }

    private void sinkIsland(char[][] grid, int r, int c, int R, int C) {
        if(r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == '0') return;
        grid[r][c] = '0';
        sinkIsland(grid, r - 1, c, R, C); 
        sinkIsland(grid, r + 1, c, R, C); 
        sinkIsland(grid, r, c - 1, R, C); 
        sinkIsland(grid, r, c + 1, R, C); 
    }
}