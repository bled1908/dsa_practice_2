class Solution {

    public int minFlips(String s) {

        int n = s.length();
        String str = s + s;

        int startWithOne = 0;
        int startWithZero = 0;

        int ans = Integer.MAX_VALUE;
        int i = 0;

        for(int j = 0; j < str.length(); j++) {

            boolean flag = (j % 2 == 0);

            if(flag) {
                if(str.charAt(j) != '1') startWithOne++;
                if(str.charAt(j) != '0') startWithZero++;
            } 
            else {
                if(str.charAt(j) != '0') startWithOne++;
                if(str.charAt(j) != '1') startWithZero++;
            }

            if(j - i + 1 > n) {

                boolean prevFlag = (i % 2 == 0);

                if(prevFlag) {
                    if(str.charAt(i) != '1') startWithOne--;
                    if(str.charAt(i) != '0') startWithZero--;
                } 
                else {
                    if(str.charAt(i) != '0') startWithOne--;
                    if(str.charAt(i) != '1') startWithZero--;
                }

                i++;
            }

            if(j - i + 1 == n) {
                ans = Math.min(ans, Math.min(startWithOne, startWithZero));
            }
        }

        return ans;
    }
}