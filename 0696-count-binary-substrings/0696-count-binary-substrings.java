class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int prevLen = 0, currLen = 1, res = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) currLen++;
            else {
                res += Math.min(prevLen, currLen);
                prevLen = currLen;
                currLen = 1;
            }
        }
        res += Math.min(prevLen, currLen);
        return res;
    }
}