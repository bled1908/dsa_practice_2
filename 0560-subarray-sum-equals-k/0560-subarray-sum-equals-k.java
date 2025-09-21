class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCounts = new HashMap<>();
        sumCounts.put(0, 1);
        int currSum = 0, count = 0;
        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            int targetPrefixSum = currSum - k;
            if(sumCounts.containsKey(targetPrefixSum)) {
                count += sumCounts.get(targetPrefixSum);
            }
            sumCounts.put(currSum, sumCounts.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}