class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int l1 = s1.length(), l2 = s2.length();
        int[] nxt = new int[l2+1], cnt = new int[l2+1];
        int count = 0, p = 0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<l1;j++){
                if(s1.charAt(j)==s2.charAt(p)){
                    p++;
                }
                if(p==l2){
                    count++;
                    p=0;
                }
            }
            cnt[i] = count;
            nxt[i] = p;
            for(int j=0;j<i;j++){
                if(nxt[j]==p){
                    int prevCnt = cnt[j];
                    int patternCnt = (cnt[i]-cnt[j])*((n1-j-1)/(i-j));
                    int remainCnt = cnt[j+(n1-j-1)%(i-j)]-cnt[j];
                    return (prevCnt+patternCnt+remainCnt)/n2;
                }
            }
        }
        return cnt[n1-1]/n2;
    }
}