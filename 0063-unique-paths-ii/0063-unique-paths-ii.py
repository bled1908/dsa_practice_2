class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[-1] * (n + 1) for _ in range(m + 1)]

        def recursion(row, column):
            if row < 0 or column < 0:
                return 0
            if obstacleGrid[row][column] == 1:
                return 0
            if row == 0 and column == 0:
                return 1
            if dp[row][column] != -1:
                return dp[row][column]
            dp[row][column] = recursion(row - 1, column) + recursion(row, column - 1)
            return dp[row][column]
        
        if obstacleGrid[0][0]:
            return 0
        return recursion(m - 1, n - 1)