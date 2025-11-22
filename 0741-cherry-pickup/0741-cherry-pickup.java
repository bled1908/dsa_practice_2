class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int dp[][][][] =new int[n][n][n][n];
        for(int rows[][][]: dp){
            for(int row[][]: rows){
                for(int ro[]:row){
                    Arrays.fill(ro,-1);
                }
            }
        }
        return Math.max(0,downPicker(0, 0, 0, 0, grid,dp));
    }

    public int downPicker(int i1, int i2, int j1, int j2, int[][] grid,int[][][][] dp) {
        if (j1 >= grid[0].length || j2 >= grid[0].length || i1 >= grid.length || i2 >= grid.length
                || grid[i1][j1] <0 || grid[i2][j2] <0 ) {
            return Integer.MIN_VALUE;
        }
        if (i1 == grid.length - 1 && j1 == grid[0].length - 1 && i2 == grid.length - 1 && j2 == grid[0].length - 1) {
            return grid[i1][j1];
        }
        if(dp[i1][j1][i2][j2]!=-1){
            return dp[i1][j1][i2][j2];
        }
        int Aleft, Adown, Bleft, Bdown;
        if (i1 == i2 && j1 == j2) {
            Aleft = grid[i1][j1] + downPicker(i1, i2, j1 + 1, j2 + 1, grid,dp);
            Adown = grid[i1][j1] + downPicker(i1, i2 + 1, j1 + 1, j2, grid,dp);
            Bleft = grid[i1][j1] + downPicker(i1 + 1, i2, j1, j2 + 1, grid,dp);
            Bdown = grid[i1][j1] + downPicker(i1 + 1, i2 + 1, j1, j2, grid,dp);

        } else {
            Aleft = grid[i1][j1] + grid[i2][j2] + downPicker(i1, i2, j1 + 1, j2 + 1, grid,dp);
            Adown = grid[i1][j1] + grid[i2][j2] + downPicker(i1, i2 + 1, j1 + 1, j2, grid,dp);
            Bleft = grid[i1][j1] + grid[i2][j2] + downPicker(i1 + 1, i2, j1, j2 + 1, grid,dp);
            Bdown = grid[i1][j1] + grid[i2][j2] + downPicker(i1 + 1, i2 + 1, j1, j2, grid,dp);
        }
        return dp[i1][j1][i2][j2]=Math.max(Math.max(Aleft, Adown), Math.max(Bleft, Bdown));
    }
}