class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int k) {
        int n = flowerbed.length;
        for(int i = 0; i < n; i++) {
            boolean left = i == 0 || flowerbed[i - 1] == 0;
            boolean right = i == n - 1 || flowerbed[i + 1] == 0;
            if(left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                k--;
            }
            if(k < 0) break;
        }
        return k <= 0;
    }
}