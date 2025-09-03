class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        left = 0
        min_size = float('inf')
        sum1 = 0
        for right in range(n):
            sum1 += nums[right]
            print(sum1)
            while sum1 >= target:
                min_size = min(right - left + 1, min_size)
                sum1 -= nums[left]
                left += 1
        return min_size if min_size != float('inf') else 0
