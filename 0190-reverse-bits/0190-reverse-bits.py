class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0
        for i in range(32):
            if n & (1 << i):
                ans |= (1 << (32 - 1 - i))
        return ans
        