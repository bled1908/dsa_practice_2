class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        return find(n);
    }

    int find(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;

        int pro = 9;  // choices for first digit
        int s = 9;    // remaining available digits
        for (int i = 1; i < n; i++) {
            pro *= s;  // multiply by decreasing digit choices
            s--;
        }
        return pro + find(n - 1); // include smaller digit counts
    }
}