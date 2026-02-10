class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            int oddCount = 0, evenCount = 0;
            for(int j =  i; j < n; j++) {
                if(seen.add(nums[j])) {
                    if(nums[j] % 2 == 0) evenCount++;
                    else oddCount++;
                }
                if(evenCount == oddCount) 
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}