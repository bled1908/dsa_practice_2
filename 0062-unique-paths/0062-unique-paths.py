class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[-1] * (n + 1) for _ in range(m + 1)]
        
        def recursion(row, column):
            if row == 1 or column == 1:
                return 1
            if dp[row][column] != -1:
                return dp[row][column]
            dp[row][column] = recursion(row - 1, column) + recursion(row, column - 1)
            return dp[row][column]
        
        return recursion(m, n)
