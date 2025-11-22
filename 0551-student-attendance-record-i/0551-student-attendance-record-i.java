class Solution {
    public boolean checkRecord(String s) {
        int ac = 0;
        int cl = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                ac++;
                if (ac > 1) return false;
                cl = 0;
            } else if (c == 'L') {
                cl++;
                if (cl > 2) return false;
            } else {
                cl = 0;
            }
        }
        return true;
    }
}