class Solution:
    def helper(self, nums, n, index, dp):
        if index == n:
            return 0
        if index == n - 1:
            return nums[n-1]
        if dp[index] != -1:
            return dp[index]
        steal = nums[index] + self.helper(nums, n, index + 2, dp)
        dontsteal = self.helper(nums, n, index + 1, dp)
        dp[index] = max(steal, dontsteal)
        return dp[index]

    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-1] * (n + 1)
        return self.helper(nums, n, 0, dp)
        