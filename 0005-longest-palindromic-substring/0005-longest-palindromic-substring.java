class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int longest = 0;
        String long_sub  = "";
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if(isPalindrome(sub) && sub.length() > longest) {
                    longest = sub.length();
                    long_sub = sub;
                }
            }
        }
        return long_sub;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left  < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}