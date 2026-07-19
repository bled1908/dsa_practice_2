class Solution {
    public int uniquePaths(int m, int n) {
        return solve(0, 0, m, n, new int[m][n], 0);
    }

    public int solve(int x, int y, int m, int n, int[][] memo, int paths) {
        if (x == m-1 && y == n-1) return paths + 1;
        if (x > m-1 || y > n-1) return paths;
        if (memo[x][y] != 0) return memo[x][y];
        int i = solve(x+1, y, m, n, memo, paths);
        int j = solve(x, y+1, m, n, memo, paths);
        memo[x][y] = i+j;
        return i+j;
    }
}