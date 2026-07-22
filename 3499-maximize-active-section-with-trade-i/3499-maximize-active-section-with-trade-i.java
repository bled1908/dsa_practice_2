class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int origOnes = 0, maxGain = 0;
        int prevZeroLen = -1000000;
        int i = 0, n = s.length();
        while(i < n) {
            int j = i;
            int c = s.charAt(i);
            while(j < n && c == s.charAt(j)) {
                j++;
            }
            int len = j - i;
            if(c == '1') {
                origOnes += len;
            } else {
                maxGain = Math.max(maxGain, prevZeroLen + len);
                prevZeroLen = len;
            }
            i = j;
        }
        return maxGain + origOnes;
    }
}