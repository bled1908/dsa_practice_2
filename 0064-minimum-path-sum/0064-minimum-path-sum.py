class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[-1] * (n) for _ in range(m)]
        dp[0][0] = grid[0][0]
        for i in range(1, n):
            dp[0][i] = grid[0][i] + dp[0][i - 1]
        for i in range(1, m):
            dp[i][0] = grid[i][0] + dp[i - 1][0]

        for row in range(1, m):
            for col in range(1, n):
                dp[row][col] = grid[row][col] + min(dp[row][col - 1], dp[row - 1][col])
        return dp[m - 1][n - 1]

        # for debugging
        for row in dp:
            print(*row)
            
        