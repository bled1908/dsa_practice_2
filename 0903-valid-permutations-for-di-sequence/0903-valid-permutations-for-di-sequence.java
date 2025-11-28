class Solution {
    int mod = 1000000007;
    public int numPermsDISequence(String s) {
        int n=s.length();
        int cnt=0;
        boolean check[]=new boolean[n+1];
         Integer dp[][]=new Integer[n+1][n+1];
        for(int i=0;i<=n;i++){
            check[i]=true;
            cnt+=fun(n-1,n,s.toCharArray(),i ,check, dp); cnt%=mod;
            check[i]=false;
        }
        return cnt%mod;
    }
    private int fun(int i, int n, char str[], int next,boolean check[], Integer dp[][]){
         if(i < 0)return 1;

         if(dp[i][next] != null)return dp[i][next]%mod;
         
         int count=0;
         for(int j=0;j<=n;j++){
             if(check[j])continue;
             if(str[i] == 'D'){
                 if(j > next){
                    check[j]=true;
                    count+=fun(i-1,n,str,j , check , dp); count%=mod;
                    check[j]=false;
                 }
             }else{
                 if(j < next){
                    check[j]=true;
                    count+=fun(i-1,n,str,j, check , dp); count%=mod;
                    check[j]=false;
                 }
             }
         }

        return dp[i][next] = count%mod;
    }
}