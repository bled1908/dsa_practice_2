import java.util.*;

public class Solution {
    class SegmentTree {
        int n;
        int[] minVal, maxVal, lazy;

        public SegmentTree(int n) {
            this.n = n;
            minVal = new int[4 * n];
            maxVal = new int[4 * n];
            lazy = new int[4 * n];
        }

        private void pushDown(int node) {
            if (lazy[node] != 0) {
                lazy[2 * node] += lazy[node];
                minVal[2 * node] += lazy[node];
                maxVal[2 * node] += lazy[node];
                
                lazy[2 * node + 1] += lazy[node];
                minVal[2 * node + 1] += lazy[node];
                maxVal[2 * node + 1] += lazy[node];
                
                lazy[node] = 0;
            }
        }

        private void pushUp(int node) {
            minVal[node] = Math.min(minVal[2 * node], minVal[2 * node + 1]);
            maxVal[node] = Math.max(maxVal[2 * node], maxVal[2 * node + 1]);
        }

        public void update(int node, int start, int end, int L, int R, int val) {
            if (start > end || start > R || end < L) return;
            if (start >= L && end <= R) {
                lazy[node] += val;
                minVal[node] += val;
                maxVal[node] += val;
                return;
            }
            pushDown(node);
            int mid = (start + end) / 2;
            update(2 * node, start, mid, L, R, val);
            update(2 * node + 1, mid + 1, end, L, R, val);
            pushUp(node);
        }

        // Binary search on the tree to find the leftmost index where value is 0
        public int findFirstZero(int node, int start, int end) {
            // If the entire range [start, end] doesn't contain 0, skip it
            if (minVal[node] > 0 || maxVal[node] < 0) return -1;
            
            if (start == end) return start;
            
            pushDown(node);
            int mid = (start + end) / 2;
            
            // Try the left child first to get the "Longest" (smallest index i)
            int res = findFirstZero(2 * node, start, mid);
            if (res == -1) {
                res = findFirstZero(2 * node + 1, mid + 1, end);
            }
            return res;
        }
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            int prev = lastSeen.getOrDefault(val, -1);
            int delta = (val % 2 == 0) ? 1 : -1;
            
            // Update range [prev + 1, j]
            st.update(1, 0, n - 1, prev + 1, j, delta);
            lastSeen.put(val, j);
            
            // Find the leftmost 'i' such that score is 0
            int leftmostI = st.findFirstZero(1, 0, n - 1);
            if (leftmostI != -1 && leftmostI <= j) {
                maxLen = Math.max(maxLen, j - leftmostI + 1);
            }
        }
        return maxLen;
    }
}