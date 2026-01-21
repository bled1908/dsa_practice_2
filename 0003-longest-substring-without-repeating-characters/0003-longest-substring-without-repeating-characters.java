class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if(map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }
            map.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}