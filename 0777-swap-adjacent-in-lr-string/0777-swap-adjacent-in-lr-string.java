class Solution {
    public boolean canTransform(String start, String end) {
        // Step 1: Remove X and check if the sequence of L,R is same
        String s1 = start.replace("X", "");
        String s2 = end.replace("X", "");
        if (!s1.equals(s2)) return false;

        int i = 0, j = 0;
        int n = start.length(), m = end.length();

        while (i < n && j < m) {
            // Skip X in start
            while (i < n && start.charAt(i) == 'X') i++;

            // Skip X in end
            while (j < m && end.charAt(j) == 'X') j++;

            if (i == n || j == m) break;

            char c = start.charAt(i);

            // Check position rules
            if (c == 'L' && i < j) return false;  // L can't move right
            if (c == 'R' && i > j) return false;  // R can't move left

            i++;
            j++;
        }

        return true;
    }
}