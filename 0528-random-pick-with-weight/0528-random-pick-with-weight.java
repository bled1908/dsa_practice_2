class Solution {

    int[] pref;
    int n;

    public Solution(int[] w) {
        this.n = w.length;
        pref = new int[n];
        for (int i = 0; i < n; i++) {
            pref[i] = w[i];
            if (i > 0)
                pref[i] += pref[i - 1];
        }
    }
    
    private int binarySearch(int x) {
        // it should be lower bound..first index >= x
        // 5 10 15
        int low = 0, high = n - 1;
        int res = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pref[mid] >= x) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public int pickIndex() {
        int total = pref[n - 1];
        int ind = (int)(Math.random() * total) + 1;
        // ind is in the range [1....total]

        // now binary search for the position
        return binarySearch(ind);
    }
}