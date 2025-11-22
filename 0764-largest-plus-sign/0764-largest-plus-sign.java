class Solution {
    int len;
    int[][] mgrid;
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        len = n;
        
        mgrid = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(mgrid[i], 1);

        
        for(int i=0; i<mines.length; i++){
            int x = mines[i][0];
            int y = mines[i][1];
            mgrid[x][y] = 0;
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mgrid[i][j] == 1)
                    max = Math.max(max, countOrder(i, j));
            }
        }
        return max;
    }

    public int countOrder(int i, int j){
        int order=1;
       
        int n=i-1, e=j+1, w=j-1, s=i+1;
       
        while(n>=0 && w>=0 && s<len && e<len){
            if(mgrid[n][j] + mgrid[i][w] + mgrid[s][j] + mgrid[i][e] == 4)
                order++;
            else
                break; 
            n--; w--; e++; s++;
        }
        
        return order;
    }
}