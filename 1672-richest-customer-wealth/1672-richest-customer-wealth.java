class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for(int[] account: accounts) {
            int mon = 0;
            for(int m: account) {
                mon += m;
            }
            res = Math.max(res, mon);
        }
        return res;
    }
}