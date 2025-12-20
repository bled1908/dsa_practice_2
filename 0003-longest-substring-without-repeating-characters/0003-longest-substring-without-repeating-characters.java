class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);
        int left = 0;
        for(int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            if(charIndex[currentChar] >= left) {
                left = charIndex[currentChar] + 1;
            }
            charIndex[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}