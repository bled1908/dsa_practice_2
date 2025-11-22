class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];
        int ans = 0;

        for(int i = 0; i < n; i++){
            if(nums1[i] == nums2[0]){
                dp[i][0] = 1;
                ans = 1;
            }
        }
        for(int j = 0; j < m; j++){
            if(nums2[j] == nums1[0]){
                dp[0][j] = 1;
                ans = 1;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}