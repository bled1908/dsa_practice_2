class Solution {
    static int t[][]= new int [101][10001];
    //here e is the number of eggs(k) and f is the number of floors(n)
    public int superEggDrop(int e, int f) {
        for(int row[]: t)
            Arrays.fill(row, -1);
        return solve(e,f);
    }
    public int solve(int e, int f){
        if(f==1 || f==0)
            return f;
        if(e==1)
            return f;
        
        if(t[e][f] != -1)
            return t[e][f];
        int l=1, r= f;
        int min= Integer.MAX_VALUE;
        
        while(l<=r)
        {
            int k = (l+r)/2; //here k is the middle floor
                
            // if egg breaks when dropped from the kth floor, 
            //then its sure that the egg will break 
            //if dropped from floors above k then we check for floors below k
            // i.e. we go down
                int down = solve(e-1, k-1); 
            
            // if egg does not break when dropped from the kth floor, 
            //then its sure that the egg will not break 
            //if dropped from floors below k then we check for floors above k
            // i.e. we go up
                int up = solve(e, f-k);
            
            int temp=1+Math.max(down,up);
            //adding one because we have used 1 attempt and max of up and down because
            //we need worst case attempts from both
            
            if(down < up)
                l= k+1;
            else
                r= k-1;
        
             min = Math.min(temp, min); //min because we have to find the min no. of moves   
            }
        
        return t[e][f]=min;  
    }
}