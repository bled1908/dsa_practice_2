class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        // first combine the array
        int[] arr = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2) {
            arr[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < n1) {
            arr[k++] = nums1[i++];
        }
        while(j < n2) {
            arr[k++] = nums2[j++];
        }

        int n3 = arr.length;
        if((n3 & 1) == 1) {
            return arr[n3 / 2];
        } else {
            return (arr[n3 / 2] + arr[(n3 / 2) - 1]) / 2.0;
        }
    }
}