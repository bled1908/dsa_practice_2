class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int empty = 0;
        int result = 0;
        int idx1 = -1, idx2 = -1;
        
        for(int i = 0; i < n; ++i){
            if(seats[i] == 1){
                empty = 0;
                if(idx1 == -1) idx1 = i;
                idx2 = i;
            } else {
                empty++;
                result = Math.max(result, (empty+1)/2);
            }
        }
        result = Math.max(result, Math.max(idx1, n-1-idx2));
        return result;
    }
}