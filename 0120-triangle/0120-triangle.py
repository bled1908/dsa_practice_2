class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        m = len(triangle)
        # The size of the last row (n) is not needed for the memoization table
        # Instead, we can use the structure of the triangle itself
        dp = {} # Using a dictionary for memoization is often cleaner

        def recursion(row, column):
            # Base case: if we are at the last row, return the value of the cell
            if row == m - 1:
                return triangle[row][column]
            
            # Check if the result is already memoized
            if (row, column) in dp:
                return dp[(row, column)]

            # Recursive step with memoization
            path_sum = triangle[row][column] + min(recursion(row + 1, column), recursion(row + 1, column + 1))
            dp[(row, column)] = path_sum
            return path_sum

        return recursion(0, 0)