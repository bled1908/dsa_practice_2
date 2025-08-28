class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();

        Arrays.sort(arr_s);
        Arrays.sort(arr_t);

        return Arrays.equals(arr_s, arr_t);
    }
}