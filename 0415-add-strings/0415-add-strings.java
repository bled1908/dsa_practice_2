class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        String result = "";
        int carry = 0;
        for(int i = len1-1, j = len2-1; i >= 0 || j >= 0 ; i--, j--){
            int val1 = (i >= 0) ? num1.charAt(i) - '0': 0;
            int val2 = (j >= 0) ? num2.charAt(j) - '0' :0;

            int out = val1 + val2 + carry;
            carry = out / 10;
            result = (out % 10) + result ;
        }
        return ((carry != 0)? (carry + result) : result);
    }
}