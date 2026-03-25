class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n <= 0) return true;
        int s = flowerbed.length;
        for(int i = 0; i < s; i++) {
            if(flowerbed[i] == 0) {
                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == (s - 1)) || (flowerbed[i + 1] == 0);
                if(left && right) {
                    flowerbed[i] = 1;
                    n--;
                }
                if(n == 0) return true;
            }
        }
        if(n <= 0) return true;
        else return false;
    }
}