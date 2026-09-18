class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] > 0) {
                    long totalValue = dfs(grid, visited, i, j);
                    if(totalValue % k == 0) count++;
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        long sum = grid[i][j];

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int[] direction: directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if(newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && !visited[newI][newJ] && grid[newI][newJ] > 0) {
                sum += dfs(grid, visited, newI, newJ);
            }
        }

        return sum;

    }
}