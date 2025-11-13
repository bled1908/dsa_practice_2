class Solution {
    public int compress(char[] chars) {
        int scribe = 0;
        int scout = 0;
        while(scout < chars.length) {
            char currChar = chars[scout];
            int count = 0;
            while(scout < chars.length && chars[scout] == currChar) {
                count++;
                scout++;
            }
            chars[scribe++] = currChar;
            if(count > 1) {
                String numString = Integer.toString(count);
                for(char c: numString.toCharArray()) {
                    chars[scribe++] = c;
                }
            }
        }
        return scribe;
    }
}