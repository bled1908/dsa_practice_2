class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1 = sorted(s1)
        n1, n2 = len(s1), len(s2)
        left = 0
        for right in range(n1 - 1, n2):
            s = s2[left:right + 1]
            s = sorted(s)
            if s == s1:
                return True
            left += 1
        return False