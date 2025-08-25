class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max_len = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < n; right++) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }
}