class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n1, n2 = len(s), len(t)
        dp = [[0] * (n2 + 1) for _ in range(n1 + 1)]
        for i in range(n1 + 1):
            dp[i][0] = 1
        # match - add the top and top - left (left diagonal) cell
        # mismatch - copy the top cell
        for row in range(1, n1 + 1):
            for col in range(1, n2 + 1):
                if s[row - 1] == t[col - 1]:
                    dp[row][col] = dp[row - 1][col] + dp[row - 1][col - 1]
                else:
                    dp[row][col] = dp[row - 1][col]
        return dp[n1][n2]