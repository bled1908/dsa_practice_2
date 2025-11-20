class Solution {
    int count=0;
    public void queens(int col,char[][] board)
    {
        if(col==board.length)
        {
            count++;
            return;
        }
        for(int row=0;row<board.length;row++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col]='Q'; // Safe place found -> place queen
                queens(col+1,board); // Check safe pos in next column
                board[row][col]='.'; // backtrack remove the queen
            }
        }
    }
    public boolean isSafe(char[][] board,int row,int col)
    {
        int dupRow=row;     int dupCol=col;
        while(row>=0 && col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row--;
            col--;
        }

        row=dupRow;         col=dupCol;
        while(col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            col--;
        }
        col=dupCol;
                while(col>=0 && row<board.length)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        // Create an empty chess board with all '.'
        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }
        // Checking postion in one column after getting a successfull position in previous column 
        queens(0,board);
        return count;
    }
}