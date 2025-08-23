class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        m = len(triangle)
        dp = {}

        def recursion(row, column):
            if row == m - 1:
                return triangle[row][column]
            if (row, column) in dp:
                return dp[(row, column)]

            dp[(row, column)] = triangle[row][column] + min(recursion(row + 1, column), recursion(row + 1, column + 1))
            return dp[(row, column)]

        return recursion(0, 0)
        # for debugging
        for row in dp:
            print(*row)