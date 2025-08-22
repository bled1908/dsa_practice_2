class Solution:
    def to_freq_arr(self, n):
        freq = [0] * 10
        while n > 0:
            freq[n % 10] += 1
            n //= 10
        return freq

    def is_equal_freq(self, a, b):
        for i in range(10):
            if a[i] != b[i]:
                return False
        return True

    def reorderedPowerOf2(self, n: int) -> bool:
        target = self.to_freq_arr(n)
        for i in range(31):
            pow_of_2 = self.to_freq_arr(1 << i)
            if self.is_equal_freq(target, pow_of_2):
                return True
        return False

        