class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Initialize graph and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        // fill our graph (0, 1) => 1 -> 0, and indegree
        for(int[] prereq: prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            adj.get(prerequisite).add(course);

            inDegree[course]++;
        }

        // Initialize our result list and queue
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        // fill our initial queue with all courses who have indegree == 0
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        // BFS Traversal (Kahn's Algorithm)
        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result.add(currentCourse);
            for(int neighbor: adj.get(currentCourse)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        if(result.size() == numCourses) 
            return result.stream().mapToInt(i -> i).toArray();
        return new int[0];
    }
}