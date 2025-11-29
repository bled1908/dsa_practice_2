class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int MOD=1_000_000_007;
        long ans=0;
        int[] freq=new int[101];
        for(int i:arr){
            freq[i]++;
        }
        for(int i=0;i<101;i++){
            for(int j=i;j<101;j++){
                int k=target-i-j;
                if(k<0 || k>100){
                    continue;
                }
                if(i==j && j==k){
                    ans+=(long)freq[i]*(freq[i]-1)*(freq[i]-2)/6;
                }
                else if(i==j && j!=k){
                    ans+=(long)freq[i]*(freq[i]-1)/2*freq[k];
                }
                else if(i<j && j<k){
                    ans+=(long)freq[i]*freq[j]*freq[k];
                }
                ans%=MOD;
            }
        }
        return (int)ans;
    }
}