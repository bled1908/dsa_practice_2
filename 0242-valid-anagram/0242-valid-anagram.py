class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # from collections import Counter
        # return Counter(s) == Counter(t)
        # only for english letters
        if len(s) != len(t):
            return False
        
        count = [0] * 26
        for ch in s:
            count[ord(ch) - ord('a')] += 1
        for ch in t:
            count[ord(ch) - ord('a')] -= 1
        
        for c in count:
            if c != 0:
                return False
        return True