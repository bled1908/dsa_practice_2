class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        n1, n2 = len(s), len(t)
        dp = [[-1] * (n2 + 1) for _ in range(n1 + 1)]
        # match - add the top and top - left (left diagonal) cell
        # mismatch - copy the top cell
        def helper(i, j):
            if dp[i][j] != -1:
                return dp[i][j]
            if j < 0:
                return 1
            if i < 0:
                return 0
            if s[i] == t[j]:
                dp[i][j] = helper(i - 1, j - 1) + helper(i - 1, j)
            else:
                dp[i][j] = helper(i - 1, j)
            return dp[i][j]
        return helper(n1 - 1, n2 - 1)