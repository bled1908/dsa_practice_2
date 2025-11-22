class Solution {
    String s1, s2;
    int[][] dp;
    int n, m;

    public int minimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        n = s1.length();
        m = s2.length();
        dp = new int[n][m];
        for (int[] i : dp) Arrays.fill(i, -1);
        return sum(0, 0);
    }

    private int sum(int i, int j) {
        if (i == n) { // delete remaining chars of s2
            int c = 0;
            for (int k = j; k < m; k++) c += s2.charAt(k);
            return c;
        }
        if (j == m) { // delete remaining chars of s1
            int c = 0;
            for (int k = i; k < n; k++) c += s1.charAt(k);
            return c;
        }
        if (dp[i][j] != -1) return dp[i][j];

        int ans;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = sum(i + 1, j + 1); // no cost if chars match
        } else {
            int a = sum(i + 1, j) + s1.charAt(i); // delete from s1
            int b = sum(i, j + 1) + s2.charAt(j); // delete from s2
            ans = Math.min(a, b);
        }
        return dp[i][j] = ans;
    }
}