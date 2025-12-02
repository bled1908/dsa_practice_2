class Solution {
    public int getSign(int[] arr, int i) {
        return arr[i - 1] < arr[i] ? 1 : (arr[i - 1] > arr[i] ? -1 : 0);
    }

    public int maxTurbulenceSize(int[] arr) {
        int maxLength = 1, n = arr.length;
        for (int i = 1, streak = 1; i < n ; ++i) {
            int curSign = getSign(arr, i);
            int prvSign = i == 1 ? -curSign : getSign(arr, i - 1);
            if (curSign != 0 && curSign + prvSign == 0) streak++;
            else streak = 1 + Math.abs(curSign);
            maxLength = Math.max(maxLength, streak);
        }
        return maxLength;
    }
}