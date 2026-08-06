class Solution {
    public int smallestNumber(int n, int t) {
        int x = n;
        while (true) {
            if (getProduct(x) % t == 0) {
                return x;
            }
            x++;
        }
    }

    private int getProduct(int num) {
        int prod = 1;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) return 0;
            prod *= digit;
            num /= 10;
        }
        return prod;
    }
}
