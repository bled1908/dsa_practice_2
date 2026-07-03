class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int index = -1;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                if (!stack.isEmpty()) {
                    stack.pop();

                    if (!stack.isEmpty()) {
                        ans = Math.max(ans, i - stack.peek());
                    } else {
                        ans = Math.max(ans, i - index);
                    }

                } else {
                    index = i;
                }
            }
        }

        return ans;
    }
}