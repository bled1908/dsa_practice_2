class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int uniquePairs = 0;
        for(int key: freqMap.keySet()) {
            if(k > 0) {
                if(freqMap.containsKey(k + key)) 
                    uniquePairs++;
            } else {
                if(freqMap.get(key) > 1) 
                    uniquePairs++;
            }
        }
        return uniquePairs;
    }
}