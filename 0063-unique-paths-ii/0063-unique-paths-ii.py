class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0] * (n) for _ in range(m)]
        dp[0][0] = 0 if obstacleGrid[0][0] == 1 else 1
        for i in range(1, n):
            if obstacleGrid[0][i - 1] == 1:
                break
            else:
                dp[0][i] = 1
        for i in range(1, m):
            if obstacleGrid[i - 1][0] == 1:
                break
            else:
                dp[i][0] = 1
        for row in range(1, m):
            for col in range(1, n):
                new_row = 0 if obstacleGrid[row][col - 1] else dp[row][col - 1]
                new_col = 0 if obstacleGrid[row - 1][col] else dp[row - 1][col]
                dp[row][col] = new_row + new_col
        return 0 if obstacleGrid[m - 1][n - 1] else dp[m - 1][n - 1]   

        # for debugging
        for row in dp:
            print(*row)

