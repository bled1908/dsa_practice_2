class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        boolean[][] pre = new boolean[n][n];
        for(int[] entry: prerequisites) {
            int u = entry[0];
            int v = entry[1];
            pre[u][v] = true;
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)
                if(pre[i][k] && pre[k][j]) pre[i][j] = true;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries) {
            res.add(pre[query[0]][query[1]]);
        }
        return res;
    }
}