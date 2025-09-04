class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n;) {
            if(nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        // for(int i = 0; i < n; i++) System.out.print(nums[i]);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1)) res.add(i + 1);
        }
        return res;
    }
}