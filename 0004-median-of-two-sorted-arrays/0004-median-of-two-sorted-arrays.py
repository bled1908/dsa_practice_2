class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merged_list = nums1 + nums2
        merged_list = sorted(merged_list)
        n = len(merged_list)
        if n & 1:
            return float(f"{merged_list[n // 2]:.5f}")
        else:
            new_no = (merged_list[n // 2] + merged_list[(n // 2) - 1]) / 2
            return float(f"{new_no:.5f}")