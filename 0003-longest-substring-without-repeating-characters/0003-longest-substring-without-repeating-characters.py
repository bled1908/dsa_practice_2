class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        my_set = set()
        left = 0
        max_len = 0
        for right in range(n):
            while s[right] in my_set:
                my_set.remove(s[left])
                left += 1
            my_set.add(s[right])
            max_len = max(right - left + 1, max_len)
        return max_len
