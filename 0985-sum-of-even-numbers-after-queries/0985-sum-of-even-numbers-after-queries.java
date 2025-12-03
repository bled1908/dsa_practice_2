class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int sumEven = 0;

        for( int num : nums ) {
            if( num % 2 == 0 ) {
                sumEven += num;
            }
        }
        int index = 0;
        for( int[] query : queries ) {
            int val = query[0];
            int idx = query[1];

            if( nums[idx] % 2 == 0 ) {
                sumEven -= nums[idx];
            }

            nums[idx] += val;

            if( nums[idx] % 2 == 0 ) {
                sumEven += nums[idx];
            }

            res[index] = sumEven;
            index += 1;
        }

        return res;
    }
}