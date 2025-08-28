class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp, dp_prev = [0] * n, [0] * n

        for i in range(n - 1, -1, -1):
            dp[i] = 1
            for j in range(i+1, n):
                if s[i] == s[j]:
                    dp[j] = dp_prev[j - 1] + 2
                else:
                    dp[j] = max(dp_prev[j], dp[j - 1])
            dp_prev = dp[:]
        
        return dp[n - 1]