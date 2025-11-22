class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        x = max;
        y = min;
        int modRemainder = x%y;

        return target <= x + y &&
               (target == x ||
               target == y ||
               target == x + y ||
               (modRemainder > 0 && (target-x) % (y-modRemainder) == 0) ||
               (modRemainder > 0 && (target-x) % modRemainder == 0)
               );

    }
}