class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp = {}

        def lps(i, j):
            if (i, j) in dp:
                return dp[(i, j)]
            if i > j:
                return 0
            if i == j:
                return 1
            if s[i] == s[j]:
                dp[(i, j)] = 2 + lps(i + 1, j - 1)
            else:
                dp[(i, j)] = max(lps(i + 1, j), lps(i, j - 1))
            return dp[(i, j)]

        return lps(0, n - 1)