class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int num: nums) {
            if(isEvenDigit(num)) res++;
        }
        return res;
    }
    private boolean isEvenDigit(int num) {
        int n = 0;
        while(num > 0) {
            num /= 10;
            n++;
        }
        return ((n & 1) == 0);
    }
}