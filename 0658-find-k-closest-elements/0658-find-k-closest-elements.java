import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // Initialize two pointers to define the initial window, covering the whole array.
        int left = 0;
        int right = arr.length - 1;

        // Shrink the window until its size is exactly k.
        // The loop removes one element per iteration.
        while (right - left + 1 > k) {
            // Compare the distance of the left and right elements from x.
            if (Math.abs(x - arr[left]) > Math.abs(arr[right] - x)) {
                // If the left element is farther, shrink the window from the left.
                left++;
            } else {
                // Otherwise (right is farther OR distances are equal), shrink from the right.
                // This correctly handles the tie-breaker rule (prefer smaller elements).
                right--;
            }
        }

        // The window [left, right] now contains the k closest elements.
        // Create the result list from this final window.
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}