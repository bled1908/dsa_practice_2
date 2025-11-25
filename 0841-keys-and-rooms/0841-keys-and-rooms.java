class Solution {
    void DFS(List<List<Integer>> rooms,int i,boolean[]visited){//i here is the starting position
        visited[i]=true;
        for(int j=0;j<rooms.get(i).size();j++){
           if(!visited[rooms.get(i).get(j)]) DFS(rooms,rooms.get(i).get(j),visited);//if we havent visited that specific room then we go there in the next recursion
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[]=new boolean[rooms.size()];
        DFS(rooms,0,visited);//we are starting from index 0 
        for(boolean i:visited){//if any of the rooms are not marked visited that means we were uunable to visit that room bcoz of absence of key
            if(!i)return false;
        }
        return true;
    }
}