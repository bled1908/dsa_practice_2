class Solution {

    public int countPalindromicSubsequences(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        int next[] = new int[n];
        int prev[] = new int[n];

        //for next
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int occr = map.getOrDefault(ch, -1);
            next[i] = occr;
            map.put(ch, i);
        }

        //for prev
        map.clear();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int occr = map.getOrDefault(ch, -1);
            prev[i] = occr;
            map.put(ch, i);
        }

        long dp[][] = new long[n][n];
        long mod = 1_000_000_000 + 7;
        for (int d = 0; d < n; d++) {
            for (int i = 0, j = d; j < n; i++, j++) {
                if (d == 0) {
                    dp[i][j] = 1;
                } else if (d == 1) {
                    dp[i][j] = 2;
                } else {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                    } else {
                        //case 1
                        if (next[i] > prev[j]) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        }
                        //case 2
                        else if (next[i] == prev[j]) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        }
                        //case 3
                        else {
                            int m = next[i];
                            int p = prev[j];

                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[m + 1][p - 1];
                        }
                    }
                }
                if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                } else {
                    dp[i][j] %= mod;
                }
            }
        }

        return (int) dp[0][n - 1];
    }
}