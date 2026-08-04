class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums) {
            if(num < low) low = num;
            if(num > high) high = num;
            numSet.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = low + 1; i < high; i++) {
            if(!numSet.contains(i))
                res.add(i);
        }
        return res;
    }
}