class Solution {
    public int myAtoi(String s) {
        long result = 0;
        boolean conversionStarted = false;
        boolean negative = false;

        for (char c : s.toCharArray()) {
            if (!conversionStarted && c == '-') {
                negative = true;
                conversionStarted = true;
            } else if (!conversionStarted && c == '+') {
                conversionStarted = true;
            } else if (c >= '0' && c <= '9') {
                long int_max = Integer.MAX_VALUE;
                result = Math.min(negative ? int_max + 1 : int_max, (result * 10) + c - '0');
                conversionStarted = true;
            } else if (!conversionStarted && c == ' ') {
                // ignore leading spaces
            } else {
                break;
            }
        }

        return negative ? (int) -result : (int) result;
    }
}