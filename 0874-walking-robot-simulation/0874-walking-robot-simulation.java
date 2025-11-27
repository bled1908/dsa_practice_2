import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] arr, int[][] obstacles) {
        int x = 0, y = 0;
        int index = 2;  // Start facing north
        int mf = 1;  // Movement factor (used to determine direction of movement)
        int max = 0;

        // Convert obstacles to a set of strings for quick lookup.
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                // Turn right
                if (index == 2) {
                    index = 1;
                    mf = 1;
                } else if (index == 1) {
                    index = -2;
                    mf = -1;
                } else if (index == -2) {
                    index = -1;
                    mf = -1;
                } else if (index == -1) {
                    index = 2;
                    mf = 1;
                }
            } else if (arr[i] == -2) {
                // Turn left
                if (index == 2) {
                    index = -1;
                    mf = -1;
                } else if (index == -1) {
                    index = -2;
                    mf = -1;
                } else if (index == -2) {
                    index = 1;
                    mf = 1;
                } else if (index == 1) {
                    index = 2;
                    mf = 1;
                }
            } else {
                // Move forward
                for (int step = 0; step < arr[i]; step++) {
                    int nextX = x;
                    int nextY = y;
                    
                    if (index == 2 || index == -2) {
                        nextY += mf;
                    } else if (index == 1 || index == -1) {
                        nextX += mf;
                    }

                    // Check for obstacles
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        int result = x * x + y * y;
                        max = Math.max(result, max);
                    } else {
                        break;  // Stop moving if there's an obstacle
                    }
                }
            }
        }
        return max;
    }
}