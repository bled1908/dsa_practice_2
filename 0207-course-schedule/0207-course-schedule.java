class Solution {
    static{
        for(int i = 0; i < 500; i++){
            canFinish(0, new int[][]{});
        }
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Setup data structure 
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize our adjav=cency list
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph and calculate in-degree
        // prerequisite -> course
        for(int[] preq: prerequisites) {
            int course = preq[0];
            int prerequisite = preq[1];
            adj.get(prerequisite).add(course);

            inDegree[course]++;
        }

        // Initialize queue with all courses having 0 prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        int nodesProcessed = 0;

        // BFS Traversal (Kahn's Algorithm)
        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            nodesProcessed++;
            for(int neighbor: adj.get(currentCourse)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        // FinalCheck: If all courses were processes, no cycle exists
        return nodesProcessed == numCourses;
    }
}