class Solution {
    public int numOfStrings(String[] patterns, String word) {
        if(patterns == null || patterns.length == 0 || word == null || word.length() == 0) {
            return 0;
        }
        int count = 0;
        for(String pattern: patterns) {
            if(word.contains(pattern)) count++;
        }
        return count;
    }
}