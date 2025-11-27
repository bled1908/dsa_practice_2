class Solution {
    public int[][] spiralMatrixIII(int row, int col, int r, int c) {
        int a = 0;
        int[][] ans = new int[row * col][2];
        boolean[][] visited = new boolean[row][col];
        int top = r, bottom = r + 1, left = c, right = c + 1;
        while (a < row * col) {
            for (int i = left; i <= right; i++) {
                if (i >= 0 && i < col && top >= 0 && top < row && !visited[top][i]) {
                    ans[a][0] = top;
                    ans[a][1] = i;
                    visited[top][i] = true;
                    a++;
                }
            }
            for (int i = top + 1; i <= bottom; i++) {
                if (i >= 0 && i < row && right >= 0 && right < col && !visited[i][right]) {
                    ans[a][0] = i;
                    ans[a][1] = right;
                    visited[i][right] = true;
                    a++;
                }
            }
            left--;
            top--;
            for (int i = right - 1; i >= left; i--) {
                if (i >= 0 && i < col && bottom >= 0 && bottom < row && !visited[bottom][i]) {
                    ans[a][0] = bottom;
                    ans[a][1] = i;
                    visited[bottom][i] = true;
                    a++;
                }
            }
            for (int i = bottom - 1; i >= top; i--) {
                if (i >= 0 && i < row && left >= 0 && left < col && !visited[i][left]) {
                    ans[a][0] = i;
                    ans[a][1] = left;
                    visited[i][left] = true;
                    a++;
                }
            }
            bottom++;
            right++;
        }
        return ans;
    }
}