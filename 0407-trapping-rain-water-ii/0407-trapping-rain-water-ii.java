class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new int[] {i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int waterTrapped = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int row = curr[0], col = curr[1], height = curr[2];

            for(int[] dir: directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    if(heightMap[newRow][newCol] < height) {
                        waterTrapped += height - heightMap[newRow][newCol];
                    }
                    minHeap.offer(new int[] {newRow, newCol, Math.max(height, heightMap[newRow][newCol])});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return waterTrapped;
    }
}