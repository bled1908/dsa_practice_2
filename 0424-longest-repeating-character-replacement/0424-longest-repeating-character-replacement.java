class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max_len = 0;
        int[] freq = new int[26];
        int max_freq = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A'] += 1;
            max_freq = Math.max(max_freq, freq[ch - 'A']);
        
            while((right - left + 1) - max_freq > k) {
                ch = s.charAt(left);
                freq[ch - 'A'] -= 1;
                left += 1;
            }
            max_len = Math.max(max_len, (right - left + 1));
        }
        return max_len;
    }
}