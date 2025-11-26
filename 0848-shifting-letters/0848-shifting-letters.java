class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] res = s.toCharArray(); 
        long totalShifts = 0; 

        for (int i = shifts.length - 1; i >= 0; i--) { 
            totalShifts = (totalShifts + shifts[i]) % 26; 
            res[i] = (char) ('a' + (res[i] - 'a' + totalShifts) % 26); 
        }

        return new String(res);
    }
}