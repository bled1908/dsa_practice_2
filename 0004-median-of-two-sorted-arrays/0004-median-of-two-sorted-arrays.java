class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int total = n1 + n2;
        int mid1 = (total - 1) / 2, mid2 = total / 2;
        int i = 0, j = 0, k = 0;
        int curr = 0, prev = 0, count = 0;
        while(count <= mid2) {
            prev = curr;
            if(i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
            count++;
        }
        if((total & 1) == 1) {
            return curr;
        } else {
            return (curr + prev) / 2.0;
        }
    }
}