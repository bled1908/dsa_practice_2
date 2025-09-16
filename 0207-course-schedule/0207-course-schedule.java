class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] edge: prerequisites) {
            int a = edge[1];
            int b = edge[0];
            adj.get(a).add(b);
            indegree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while(!q.isEmpty()) {
            int t = q.poll();
            count++;
            for(int x: adj.get(t)) {
                indegree[x]--;
                if(indegree[x] == 0) {
                    q.offer(x);
                }
            }
        }
        return count == n;
    }
}