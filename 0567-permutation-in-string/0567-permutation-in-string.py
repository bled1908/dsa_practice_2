class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        dict1 = {}
        for ch in s1:
            dict1[ch] = dict1.get(ch, 0) + 1
        n1, n2 = len(s1), len(s2)
        if n1> n2:
            return False
        left = 0
        dict2 = {}
        for i in range(n1):
            dict2[s2[i]] = dict2.get(s2[i], 0) + 1
        if dict1 == dict2:
            return True
        for right in range(n1, n2):
            dict2[s2[right]] = dict2.get(s2[right], 0) + 1
            dict2[s2[left]] -= 1
            if dict2[s2[left]] == 0:
                del dict2[s2[left]]
            left += 1
            if dict1 == dict2:
                return True
        return False