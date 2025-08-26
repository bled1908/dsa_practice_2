class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_len = 0
        left = 0
        freq = [0] * 26
        max_freq = 0
        for right in range(len(s)):
            freq[ord(s[right]) - ord('A')] += 1
            max_freq = max(max_freq, freq[ord(s[right]) - ord('A')])

            while (right - left + 1) - max_freq > k:
                freq[ord(s[left]) - ord('A')] -= 1
                left += 1
            
            max_len = max(max_len, right - left + 1)
        return max_len