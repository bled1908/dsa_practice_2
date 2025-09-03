class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        dict1 = {}
        for ch in s1:
            dict1[ch] = dict1.get(ch, 0) + 1
        n1, n2 = len(s1), len(s2)
        left = 0
        for right in range(n1 - 1, n2):
            s = s2[left:right + 1]
            dict2 = {}
            for ch in s:
                dict2[ch] = dict2.get(ch, 0) + 1
            if dict1 == dict2:
                return True
            left += 1
        return False