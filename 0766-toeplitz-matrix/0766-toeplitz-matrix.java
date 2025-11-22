class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=m-1;i>=0;i--){
            int row=i;
            int col=0;
            int x=matrix[row][col];
            while(row<=m-1 && col<=n-1){
                if(matrix[row][col]!=x) return false;
                row++;
                col++;
            }
        }
        for(int i=1;i<n;i++){
            int row=0;
            int col=i;
            int x=matrix[row][col];
            while(row<=m-1 && col<=n-1){
                if(matrix[row][col]!=x) return false;
                row++;
                col++;
            }
        }
        return true;
    }
}