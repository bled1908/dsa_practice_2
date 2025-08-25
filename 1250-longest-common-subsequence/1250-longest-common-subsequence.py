class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        s1 = len(text1)
        s2 = len(text2)
        dp = [[-1] * s2 for _ in range(s1)]
        
        def helper(a, b):
            if a < 0 or b < 0:
                return 0
            if dp[a][b] != -1:
                return dp[a][b]
            if text1[a] == text2[b]:
                dp[a][b] = 1 + helper(a - 1, b - 1)
            else:
                dp[a][b] = max(helper(a, b - 1), helper(a - 1, b))  
            return dp[a][b]
        
        return helper(s1 - 1, s2 - 1)
