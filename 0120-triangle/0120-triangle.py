class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        m = len(triangle)
        n = len(triangle[m - 1])
        dp = triangle[m - 1]
        for row in range(m - 2, -1, -1):
            for col in range(len(triangle[row])):
                dp[col] = triangle[row][col] + min(dp[col + 1], dp[col])
        return dp[0]
        # for debugging
        print(dp)