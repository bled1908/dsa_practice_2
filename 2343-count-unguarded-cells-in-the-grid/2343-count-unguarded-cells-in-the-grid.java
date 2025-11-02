class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // Mark walls as 2
        for(int[] wall: walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        
        // Mark guards as 1
        for(int[] guard: guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        
        // Process each guard's visibility
        for(int[] guard: guards) {
            int row = guard[0];
            int col = guard[1];
            
            // Look upward
            for(int r = row - 1; r >= 0; r--) {
                if(grid[r][col] == 1 || grid[r][col] == 2) break;
                grid[r][col] = 3;
            }
            
            // Look downward
            for(int r = row + 1; r < m; r++) {
                if(grid[r][col] == 1 || grid[r][col] == 2) break;
                grid[r][col] = 3;
            }
            
            // Look left
            for(int c = col - 1; c >= 0; c--) {
                if(grid[row][c] == 1 || grid[row][c] == 2) break;
                grid[row][c] = 3;
            }
            
            // Look right
            for(int c = col + 1; c < n; c++) {
                if(grid[row][c] == 1 || grid[row][c] == 2) break;
                grid[row][c] = 3;
            }
        }
        
        // Count unguarded cells (only 0s)
        int count = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 0) count++;
            }
        }
        return count;
    }
}
