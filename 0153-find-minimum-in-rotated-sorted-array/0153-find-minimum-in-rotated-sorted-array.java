class Solution {
    private int peak(int[] arr, int s, int e){
        int mid = s + (e - s) / 2;
        while (s < e) {
            if (arr[s] < arr[e]) return s; 
            if (arr[mid] >= arr[s]) {
                s = mid + 1;
            } else {
                e = mid;
            }
            mid = s + (e - s) / 2;
        }
        return s;
    }

    public int findMin(int[] arr) {
        int n = arr.length;
        int minIndex = peak(arr, 0, n - 1);
        return arr[minIndex];
    }
}