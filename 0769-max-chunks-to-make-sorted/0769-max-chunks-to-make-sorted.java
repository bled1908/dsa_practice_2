class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int maxSoFar = 0;

        for(int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);

            // Maintain monotonic decreasing stack
            while(!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);

            // Check if the chunk can end here
            if(i == maxSoFar) {
                count++;
            }
        }

        return count;
    }
}