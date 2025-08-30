class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        int i = n1;
        int j = n2;
        while(i > 0 && j > 0) {
            if (s1[i - 1] == s2[j - 1]) {
                str.append(s1[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str.append(s1[i - 1]);
                i--;
            } else {
                str.append(s2[j - 1]);
                j --;
            }
        }
        while(i > 0) {
            str.append(s1[i - 1]);
            i--;
        }
        while(j > 0) {
            str.append(s2[j - 1]);
            j--;
        }
        return str.reverse().toString();
        // for(int[] row: dp) {
        //     for(int val: row) {
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }
        // return null;
    }
}