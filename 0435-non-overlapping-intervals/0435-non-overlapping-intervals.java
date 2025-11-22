class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by end time in ascending order
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        // Track the maximum number of non-overlapping intervals we can keep
        int nonOverlappingCount = 1;
        
        // Track the end time of the last selected interval
        int lastEndTime = intervals[0][1];

        // Start from second interval since first is already selected
        for (int i = 1; i < intervals.length; i++) {
            // If current interval starts at or after the last end time, no overlap
            if (intervals[i][0] >= lastEndTime) {
                nonOverlappingCount++;
                lastEndTime = intervals[i][1];
            }
            // If there's overlap, we skip this interval (implicitly removing it)
        }

        // Return number of intervals to remove
        return intervals.length - nonOverlappingCount;
    }
}