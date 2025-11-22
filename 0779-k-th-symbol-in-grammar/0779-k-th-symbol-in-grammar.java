class Solution {
    public int kthGrammar(int n, int k) {
        // Base cases
        if (n == 1) return 0;
        
        // Find parent's position in previous row
        int parentK = (k + 1) / 2;
        int parent = kthGrammar(n - 1, parentK);
        
        // Determine current value based on parent and position
        if (parent == 0) {
            return (k % 2 == 1) ? 0 : 1;
        } else {
            return (k % 2 == 1) ? 1 : 0;
        }
    }
}