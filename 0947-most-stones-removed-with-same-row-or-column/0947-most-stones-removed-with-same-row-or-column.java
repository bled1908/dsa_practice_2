class Solution {
    int[] parent;
    int[] rank;
    public void init(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(rank[parentA]==rank[parentB]){
            parent[parentB] = parentA;
            rank[parentA]++;
        }else if(rank[parentA]<rank[parentB]){
            parent[parentA] = parentB;
        }else{
            parent[parentB] = parentA;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;

        // Approach using Disjoint Set Union
        init(n);
        for(int i=0; i<n; i++){ // try to make the groups
            int r = stones[i][0]; // ith row
            int c = stones[i][1]; // ith col
            int parent_i = find(i); // parent of i
            for(int j=i+1; j<n; j++){
                int currR = stones[j][0]; // jth row
                int currC = stones[j][1]; // jth col
                if(r==currR || c==currC){ // if either row or col matches
                    union(parent_i, j); // take them in same group
                }
            }
        }

        int groups = 0; // total no. of groups 
        for(int i=0; i<n; i++){
            if(parent[i]==i) groups++;
        }
        // maximum stones we can remove = total stones - number of groups
        return n - groups;
    }
}