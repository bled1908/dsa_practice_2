class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        
        for(char c : n.toCharArray()) {
            int digit = c - '0';
            ans = Math.max(ans, digit);
            
            if(ans == 9) break;
        }
        
        return ans;
    }
}