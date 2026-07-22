class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int weight: weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean canShip(int[] weights, int days, int mid) {
        int day = 1;
        int curr = 0;
        for (int weight: weights) {
            if(curr + weight <= mid) {
                curr += weight;
            } else {
                day++;
                curr = weight;
                if(day > days) return false;
            }
        }
        return true;
    }
}