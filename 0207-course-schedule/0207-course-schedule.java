class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Setup data structure 
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize our adjacency list
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph and calculate in-degree
        // prerequisite -> course
        for(int[] preq: prerequisites) {
            int course = preq[0];
            int prerequisite = preq[1];
            adj.get(prerequisite).add(course);
        }

        // Initialize color states: 0 = white (unvisited), 1 = gray (visiting), 2 = black (visited)
        int[] colors = new int[numCourses];

        // Perform dfs
        for(int i = 0; i < numCourses; i++) {
            if(colors[i] == 0) {
                if(hasCycle(adj, i, colors)) return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(List<List<Integer>> adj, int course, int[] colors) {
        // Mark current course as gray -> visiting
        colors[course] = 1;

        // Visit all neighbors (courses that depend on the current one)
        for(int neighbor: adj.get(course)) {
            if(colors[neighbor] == 1) return true; // there is a cycle, as found a back edge to a gray one
            if(colors[neighbor] == 0) {
                if(hasCycle(adj, neighbor, colors)) return true;
                //found cycle in deeper recursion
            }
        }
        colors[course] = 2; // Mark current course as black(finished)
        return false;
    }
}