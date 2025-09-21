class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int l = 0, maxlen = 0;
        for(int r = 0; r < n; r++) {
            if(charMap.containsKey(s.charAt(r)) && charMap.get(s.charAt(r)) >= l) {
                l = charMap.get(s.charAt(r)) + 1;
            }
            charMap.put(s.charAt(r), r);
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }
}