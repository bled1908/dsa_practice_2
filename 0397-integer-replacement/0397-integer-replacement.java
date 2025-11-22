class Solution {
    // Memoization map to store results of subproblems
    private HashMap<Long, Integer> memo = new HashMap<>();

    // Recursive function to solve the problem
    private int solve(long n) {
        if (n == 1) return 0;  // Base case
        if (memo.containsKey(n)) return memo.get(n);  // Return memoized result

        int even = Integer.MAX_VALUE;
        int oddMinus = Integer.MAX_VALUE;
        int oddPlus = Integer.MAX_VALUE;

        // If the number is even, the only choice is to divide by 2
        if (n % 2 == 0) {
            even = 1 + solve(n / 2);
        } else {
            // If the number is odd, try both n-1 and n+1
            oddMinus = 1 + solve(n - 1);
            oddPlus = 1 + solve(n + 1);
        }

        // Take the minimum of all possible operations
        int result = Math.min(even, Math.min(oddMinus, oddPlus));
        memo.put(n, result);  // Memoize the result
        return result;
    }

    // Main function to initiate the solving process
    public int integerReplacement(int n) {
        return solve(n);
    }
}