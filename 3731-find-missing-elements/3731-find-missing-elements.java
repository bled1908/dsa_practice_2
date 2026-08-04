class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        boolean[] present = new boolean[101];
        for(int num: nums) {
            if(num < low) low = num;
            if(num > high) high = num;
            present[num] = true;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = low + 1; i < high; i++) {
            if(!present[i])
                res.add(i);
        }
        return res;
    }
}