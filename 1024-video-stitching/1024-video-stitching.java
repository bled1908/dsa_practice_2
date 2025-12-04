class Solution {
    public int videoStitching(int[][] clips, int time) {
        int res = 0;
        Arrays.sort(clips, (a,b) ->  a[0] - b[0]);
        int start = 0, end = 0, index = 0;
        while (start < time) {
            while (index < clips.length && clips[index][0] <= start) {
                end = Math.max(end, clips[index][1]);
                index++;
            }
            if (start == end) return -1;
            start = end;
            res++;
        }
        return res;
    }
}