class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Vertex> rottenOranges = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        System.out.println("n = " + n + " , m = " + m);
        
        int fresh_count = 0;
        for (int i =0; i< n; i++) {
            for (int j =0; j< m; j++) {
                if(grid[i][j]==2) {
                    rottenOranges.add(new Vertex(i, j, 0));
                }
                if(grid[i][j]==1) {
                    fresh_count++;
                }
            }
        }

        System.out.println("Fresh oranges at start = " + fresh_count);

        int ro_count = 0;
        int max_time = 0;
        while(!rottenOranges.isEmpty()) {
            Vertex rottenOrange = rottenOranges.poll();

            int i = rottenOrange.i;
            int j = rottenOrange.j;
            int time = rottenOrange.time;

            max_time = Math.max(max_time, time);

            System.out.println("i = " + i + " , j = " + j + " , time = " + time);
            
            if(j-1 >= 0 && grid[i][j-1]==1) {
                rottenOranges.add(new Vertex(i, j-1, time + 1));
                grid[i][j-1] = 2;
                ro_count++;
            }
            if(j+1 < m && grid[i][j+1]==1) {
                rottenOranges.add(new Vertex(i, j+1, time + 1));
                grid[i][j+1] = 2;
                ro_count++;
            }

            if(i-1 >= 0 && grid[i-1][j] == 1) {
                rottenOranges.add(new Vertex(i-1, j, time + 1));
                grid[i-1][j] = 2;
                ro_count++;
            }
            if(i+1 < n && grid[i+1][j] == 1) {
                grid[i+1][j] = 2;
                rottenOranges.add(new Vertex(i+1, j, time + 1));
                ro_count++;
            }
        }
        System.out.println("Max time: " + max_time + " ro_count at end: " + ro_count);
        
        System.out.println("Remaining Fresh Oranges: " + (fresh_count - ro_count));
        if(ro_count == fresh_count) {
            return max_time;
        } else {
            return -1;
        }
    }
}

class Vertex {
    int i;
    int j;
    int time;

    public Vertex(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }

}