class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<int[]> merged = new LinkedList<>();

        merged.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] lastMerged = merged.getLast();
            int[] current = intervals[i];

            if(lastMerged[1] >= current[0]) {
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}