class Solution {
    List<Integer> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i <= 9; i++){
            solve(n,k,i,i);
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    private void solve(int n,int k,int lastPick,int picked){
        if(String.valueOf(picked).length() == n){
            res.add(picked);
            return;
        }
        for(int i = 0;i <= 9; i++){
            int diff = Math.abs(lastPick - i);
            if(diff == k){
                solve(n,k,i,picked * 10 + i);
            }
        }
    }
}