class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                if (board[r][c] == '.') {

                    for (int num = 1; num <= 9; num++) {

                        if (isSafe(r, c, num, board)) {

                            board[r][c] = (char) (num + '0');

                            if (backtrack(board)) {
                                return true;
                            }

                            board[r][c] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(int row, int col, int num, char[][] board) {

        for (int c = 0; c < 9; c++) {
            if (board[row][c] == (char) (num + '0')) {
                return false;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (board[r][col] == (char) (num + '0')) {
                return false;
            }
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {

                if (board[r][c] == (char) (num + '0')) {
                    return false;
                }
            }
        }

        return true;
    }
}