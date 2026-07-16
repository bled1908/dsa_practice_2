class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int runningMax = 0;

        for(int i = 0; i < n; i++) {
            runningMax = Math.max(nums[i] ,runningMax);
            prefixGcd[i] = gcd(nums[i], runningMax);
        }

        Arrays.sort(prefixGcd);

        long totalSum = 0;

        for(int i = 0; i < n / 2; i++) {
            totalSum += gcd(prefixGcd[i], prefixGcd[n - i - 1]);
        }

        return totalSum;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}