public class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (cnt == 0 && s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == '(') {
                cnt++;
                ans.append(s.charAt(i));
            } else if (cnt == 1 && s.charAt(i) == ')') {
                cnt--;
            } else {
                cnt--;
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}