class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, sum = Arrays.stream(nums).sum();
        Set<Integer>[] a = gen(0, n/2-1, nums);
        Set<Integer>[] b = gen(n/2, n-1, nums);
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                if (i+j>0 && i+j < n && sum*(i+j)%n == 0){
                    for (int cur : a[i]){
                        if (b[j].contains(sum*(i+j)/n-cur)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private Set<Integer>[] gen(int lo, int hi, int[] nums){
        int sz = hi-lo+1;
        Set<Integer>[] ans = new HashSet[sz+1];
        Arrays.setAll(ans, o -> new HashSet<>());
        ans[0].add(0);
        int[] bits = new int[1<<sz];
        int[] sum = new int[1<<sz];
        for (int i = 0; i < sz; i++){
            sum[1<<i]=nums[lo+i];
        }
        for (int i = 1; i < 1<<sz; i++){
            bits[i]=bits[i&(i-1)]+1;
            sum[i] = sum[i&(i-1)]+sum[i&-i];
            ans[bits[i]].add(sum[i]);
        }
        return ans;
    }
}