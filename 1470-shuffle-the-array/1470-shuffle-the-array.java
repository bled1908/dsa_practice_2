class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0, j = n;
        for(int k = 0; k < 2 * n; k++) {
            if(k % 2 == 0) res[k] = nums[i++];
            else res[k] = nums[j++];
        }
        return res;
    }
}