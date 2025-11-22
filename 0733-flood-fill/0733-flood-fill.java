class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        
        // If the color is same, no need to change
        if (oldColor == newColor) return image;
        
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        // Check boundaries
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;

        // Stop if current cell is not of oldColor
        if (image[r][c] != oldColor) return;

        // Change color
        image[r][c] = newColor;

        // Move in all 4 directions
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }
}