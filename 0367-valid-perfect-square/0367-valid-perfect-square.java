class Solution {
    public boolean isPerfectSquare(int num) {

        return (long) Math.sqrt(num) * (long) Math.sqrt(num) == num; 
        
    }
}