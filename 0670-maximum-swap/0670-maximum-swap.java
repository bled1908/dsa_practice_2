class Solution {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        char[] digits = s.toCharArray();
        int maxNum = num;
        
        // Try all possible swaps
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                // Swap digits[i] and digits[j]
                swap(digits, i, j);
                
                // Convert to integer and update max
                int currentNum = Integer.parseInt(new String(digits));
                maxNum = Math.max(maxNum, currentNum);
                
                // Swap back
                swap(digits, i, j);
            }
        }
        
        return maxNum;
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}