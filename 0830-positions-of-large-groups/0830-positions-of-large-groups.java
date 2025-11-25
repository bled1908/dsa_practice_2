class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int n = s.length();

        int start = 0;

        for(int i = 0; i < n; i++){
            if(i == n - 1 || s.charAt(i) != s.charAt(i + 1)){
                int grpLength = i - start + 1;

                if(grpLength >= 3){
                    res.add(Arrays.asList(start, i));
                }
                start = i + 1;
            }
        }
        return res;
    }
}