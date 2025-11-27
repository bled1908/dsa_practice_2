class Solution {
    ArrayList<Integer>[] adj;
    boolean[] visited;
    int[] color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        adj = new ArrayList[n+1];
        for(int i = 0;i <= n;i++){
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        color = new int[n+1];
        for(int[] ele: dislikes){
            //System.out.println(ele[0]+" 0 "+ele[1]);
            adj[ele[0]].add(ele[1]);
            adj[ele[1]].add(ele[0]);
        }
        for(int i = 1;i <= n;i++){
            if(!visited[i]){
                if(!dfs(i, 1)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, int col){
        visited[node] = true;
        color[node] = col;
        boolean ans = true;
        for(int ele: adj[node]){
            if(color[ele] != 0 && color[ele] == col){
                return false;
            }
            if(!visited[ele]){
                if(col == 1){
                    ans &= dfs(ele, 2);
                }
                else{
                    ans &= dfs(ele, 1);
                }
            }
        }
        return ans;
    }
}