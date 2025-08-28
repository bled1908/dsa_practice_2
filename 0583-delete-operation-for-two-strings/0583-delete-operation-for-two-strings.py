class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        n1 = len(word1)
        n2 = len(word2)
        dp = [[0] * (n2 + 1) for _ in range(n1 + 1)]
        for row in range(1, n1 + 1):
            for col in range(1, n2 + 1):
                if word1[row - 1] == word2[col - 1]:
                    dp[row][col] = dp[row - 1][col - 1] + 1
                else:
                    dp[row][col] = max(dp[row - 1][col], dp[row][col - 1])
        lcs = dp[n1][n2]
        return (n1 - lcs) + (n2 - lcs)