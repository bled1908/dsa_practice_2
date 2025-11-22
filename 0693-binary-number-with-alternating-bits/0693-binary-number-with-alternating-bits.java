class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        char[] arr = binary.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}