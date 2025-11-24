class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {

                row[i] = Math.max(row[i],grid[i][j]);
                col[j] = Math.max(col[j],grid[i][j]);

            }
        }

        int increase = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int allowed = Math.min(row[i], col[j]);
                increase += allowed - grid[i][j];
            }
        }
        return increase;
    }
}