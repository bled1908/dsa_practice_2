class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] scores = new long[n];
        for(int i = 0; i < n; i++) {
            scores[edges[i]] += i;
        }
        long maxScore = -1;
        int bestNode = -1;
        for(int i = 0; i < n; i++) {
            if(scores[i] > maxScore) {
                maxScore = scores[i];
                bestNode = i;
            }
        }
        return bestNode;
    }
}