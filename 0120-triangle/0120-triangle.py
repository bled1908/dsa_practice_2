class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        m = len(triangle)
        n = len(triangle[m - 1])
        dp = [[float('inf')] * n for _ in range(m)]
        for i in range(n):
            dp[m - 1][i] = triangle[m - 1][i] 
        for row in range(m - 2, -1, -1):
            for col in range(len(triangle[row])):
                dp[row][col] = triangle[row][col] + min(dp[row + 1][col], dp[row + 1][col + 1])
        return dp[0][0]
        # for debugging
        for row in dp:
            print(*row)