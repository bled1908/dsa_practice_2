class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        m = len(triangle)
        n = len(triangle[m - 1])
        dp = [[10001] * (n) for _ in range(m)]

        def recursion(row, column):
            if row == m - 1:
                return triangle[row][column]
            if dp[row][column] != 10001:
                return dp[row][column]

            dp[row][column] = triangle[row][column] + min(recursion(row + 1, column), recursion(row + 1, column + 1))
            return dp[row][column]

        return recursion(0, 0)
        # for debugging
        for row in dp:
            print(*row)