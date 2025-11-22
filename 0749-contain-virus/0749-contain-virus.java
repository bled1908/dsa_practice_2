import java.util.*;

class Cell {
    int row, col;
    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class InfectionCluster {
    int wallsNeeded, exposedCells;
    List<Cell> infectedCells;
    
    InfectionCluster() {
        this.wallsNeeded = 0;
        this.exposedCells = 0;
        this.infectedCells = new ArrayList<>();
    }
}

class Solution {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    
    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
    
    private void exploreCluster(int x, int y, int rows, int cols, int[][] grid, boolean[][] visited, boolean[][] unvisitedCells, InfectionCluster cluster) {
        visited[x][y] = true;
        cluster.infectedCells.add(new Cell(x, y));

        for (int i = 0; i < 4; i++) {
            int nx = x + DR[i], ny = y + DC[i];

            if (isValid(nx, ny, rows, cols) && !visited[nx][ny] && grid[nx][ny] != -999) {
                if (grid[nx][ny] == 1) {
                    exploreCluster(nx, ny, rows, cols, grid, visited, unvisitedCells, cluster);
                } else if (grid[nx][ny] == 0) {
                    cluster.wallsNeeded++;
                    if (!unvisitedCells[nx][ny]) {
                        unvisitedCells[nx][ny] = true;
                        cluster.exposedCells++;
                    }
                }
            }
        }
    }

    public int containVirus(int[][] grid) {
        int totalWalls = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        while (true) {
            PriorityQueue<InfectionCluster> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.exposedCells, a.exposedCells));
            boolean[][] visited = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        InfectionCluster cluster = new InfectionCluster();
                        exploreCluster(i, j, rows, cols, grid, visited, new boolean[rows][cols], cluster);
                        if (cluster.exposedCells > 0) {
                            maxHeap.add(cluster);
                        }
                    }
                }
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            InfectionCluster largestCluster = maxHeap.poll();
            totalWalls += largestCluster.wallsNeeded;

            for (Cell infectedCell : largestCluster.infectedCells) {
                grid[infectedCell.row][infectedCell.col] = -999;
            }

            while (!maxHeap.isEmpty()) {
                InfectionCluster cluster = maxHeap.poll();
                for (Cell infectedCell : cluster.infectedCells) {
                    for (int i = 0; i < 4; i++) {
                        int nx = infectedCell.row + DR[i], ny = infectedCell.col + DC[i];
                        if (isValid(nx, ny, rows, cols) && grid[nx][ny] == 0) {
                            grid[nx][ny] = 1;
                        }
                    }
                }
            }
        }

        return totalWalls;
    }
}