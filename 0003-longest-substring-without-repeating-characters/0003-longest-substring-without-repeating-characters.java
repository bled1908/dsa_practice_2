class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max_len = 0, left = 0;
        for(int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            if(map.containsKey(curr)) {
                left = Math.max(left, map.get(curr) + 1);
            }
            map.put(curr, right);
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}