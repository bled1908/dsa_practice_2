class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;
        int i = 1;
        while (i < n - 1) {
            // check peak
            // greater than all surrounding elements
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                // check left hill
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }
                // check right hill
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                // update longest mountain
                longest = Math.max(longest, right - left + 1);
                // move i to the end of the current mountain
                i = right;
            } else{
                // continue till you find a peak
                i++;
            }
        }
        return longest;
    }
}