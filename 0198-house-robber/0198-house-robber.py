class Solution:
    def totalAmount(self, n, nums, dp):
        if n < 0:
            return 0
        if dp[n] != -1:
            return dp[n]
        rob = nums[n] + self.totalAmount(n - 2, nums, dp)
        skip = self.totalAmount(n - 1, nums, dp)
        dp[n] = max(rob, skip)
        return dp[n] 

    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-1] * (n + 1)
        return self.totalAmount(n - 1, nums, dp)
        