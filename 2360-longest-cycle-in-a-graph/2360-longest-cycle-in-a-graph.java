class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int maxCycleLength = -1;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                Map<Integer, Integer> pathDistances = new HashMap<>();
                int curr = i;
                int distance = 0;
                while(curr != -1 && !visited[curr]) {
                    pathDistances.put(curr, distance);
                    visited[curr] = true;
                    distance++;
                    curr = edges[curr];
                }
                if(curr != -1 && pathDistances.containsKey(curr)) {
                    int cycleLength = distance - pathDistances.get(curr);
                    maxCycleLength = Math.max(maxCycleLength, cycleLength);
                }
            }
        }
        return maxCycleLength;
    }
}