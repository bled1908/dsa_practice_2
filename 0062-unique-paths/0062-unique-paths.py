class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]
        for i in range(n):
            dp[0][i] = 1
        for i in range(m):
            dp[i][0] = 1
        for row in range(1, m):
            for col in range(1, n):
                dp[row][col] = dp[row][col - 1] + dp[row - 1][col]
        return dp[m - 1][n - 1]