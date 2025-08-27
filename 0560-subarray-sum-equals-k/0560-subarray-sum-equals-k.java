class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);
        for(int num: nums) {
            currSum += num;
            if(prefixCounts.containsKey(currSum - k)) {
                count += prefixCounts.get(currSum - k);
            }
            prefixCounts.put(currSum, prefixCounts.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}