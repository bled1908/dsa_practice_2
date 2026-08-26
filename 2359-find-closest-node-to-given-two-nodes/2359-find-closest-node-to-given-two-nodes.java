class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        traverse(edges, node1, dist1);
        traverse(edges, node2, dist2);
        
        int minMaxDist = Integer.MAX_VALUE;
        int bestNode = -1;
        for(int i = 0; i < n; i++) {
            if(dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if(maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    bestNode = i;
                }
            }
        }
        return bestNode;
    }

    private void traverse(int[] edges, int startNode, int[] dist) {
        int curr = startNode;
        int dis = 0;
        while(curr != -1 && dist[curr] == -1) {
            dist[curr] = dis++;
            curr = edges[curr];
        }
    }
}