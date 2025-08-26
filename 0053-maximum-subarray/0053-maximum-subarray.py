class Solution:
    def maxSubArray(self, nums: List[int]) -> int:

        def maxCrossingSum(nums, left, mid, right):
            # Left half (max suffix sum)
            left_sum = float('-inf')
            total = 0
            for i in range(mid, left - 1, -1):
                total += nums[i]
                left_sum = max(left_sum, total)

            # Right half (max prefix sum)
            right_sum = float('-inf')
            total = 0
            for i in range(mid + 1, right + 1):
                total += nums[i]
                right_sum = max(right_sum, total)
            
            return left_sum + right_sum
        
        def maxSubArrayHelper(nums, left, right):
            if left == right:
                return nums[left]
            mid = (left + right) // 2
            left_sum = maxSubArrayHelper(nums, left, mid)
            right_sum = maxSubArrayHelper(nums, mid + 1, right)
            cross_sum = maxCrossingSum(nums, left, mid, right)

            return max(left_sum, right_sum, cross_sum)

        return maxSubArrayHelper(nums, 0, len(nums) - 1)