class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0, max = 0, n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i]==0) sum-=1;
            else sum+=1;
            //System.out.println(sum);
            if(sum==0) {
                max = i+1;
                continue;
            }
            else if(map.containsKey(sum)) {
                max = Math.max(max,i-map.get(sum));
            }
            if(!map.containsKey(sum)) map.put(sum,i);
        }
        return max;
    }
}