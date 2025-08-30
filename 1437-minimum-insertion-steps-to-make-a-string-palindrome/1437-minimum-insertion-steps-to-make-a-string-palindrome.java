class Solution {
    public int minInsertions(String s) {
        int lcs = findLcs(s);
        return s.length() - lcs;
    }

    private int findLcs(String s) {
        char[] s1 = s.toCharArray();
        char[] s2 = new StringBuilder(s).reverse().toString().toCharArray();

        int n = s1.length;

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}