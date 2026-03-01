class Solution {
    public boolean checkIfPangram(String s) {
        if(s.length() < 26) return false;
        int u = 0;
        boolean[] seen = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            int index = c - 'a';
            if(!seen[index]) {
                seen[index] = true;
                u++;
            } 
            if(u == 26) return true;
        }
        return false;
    }
}