class Solution {
    private final int MOD = 1337;
    public int superPow(int a, int[] b) {
        // corner case
        if (a == 1 || a == 0) return a;
        
        // Decimal Decomposing of Exponent
        int result = 1;
        int spContribution = a % MOD;

        for (int i = b.length - 1; i >= 0; i--) {
            if (b[i] != 0) { // No need to apply contribution to result if b[i] is 0
                result = (result * powerWithMOD(spContribution, b[i])) % MOD;
            }
            spContribution = powerWithMOD(spContribution, 10);
        }

        return result;
    }

    // Helper
    // Given int a and n, compute (a ^ n) % MOD
    // assert n >= 0
    private int powerWithMOD(int a, int n) {
        // corner cases
        if (a == 0 || n == 1) return a % MOD;
        if (a == 1 || n == 0) return 1;

        // Bit Decomposing of exponent n
        int result = 1;
        int contribution = a % MOD;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                result = (result * contribution) % MOD;
            }
            contribution = (contribution * contribution) % MOD;
        }

        return result;
    }

}