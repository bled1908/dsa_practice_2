class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)

        # find index of smallest element(pivot)
        left, right = 0, n - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        pivot = left

        left, right = 0, n - 1
        while left <= right:
            mid = (left + right) // 2
            real_mid = (mid + pivot) % n
            if nums[real_mid] == target:
                return real_mid
            if nums[real_mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1
        