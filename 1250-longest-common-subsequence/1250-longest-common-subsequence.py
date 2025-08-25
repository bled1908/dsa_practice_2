class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        s1 = len(text1) + 1
        s2 = len(text2) + 1
        
        dp = [[0] * (s2) for _ in range(s1)]
        for row in range(1, s1):
            for col in range(1, s2):
                dp[row][col] = 1 + dp[row - 1][col - 1] if text1[row - 1] == text2[col - 1] else max(dp[row - 1][col], dp[row][col - 1]) 
        return dp[s1 - 1][s2 - 1]
        
        # debugging
        for row in dp:
            print(*row)
