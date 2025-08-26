class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr_sum = nums[0]
        max_sum = nums[0]
        start = end = 0
        s = 0 #temporary start
        for i in range(1, len(nums)):
            if nums[i] > curr_sum + nums[i]:
                s = i
                curr_sum = nums[i]
            else:
                curr_sum += nums[i]
            if curr_sum > max_sum:
                max_sum = curr_sum
                start = s
                end = i
        
        print(max_sum, nums[start: end + 1])
        return max_sum