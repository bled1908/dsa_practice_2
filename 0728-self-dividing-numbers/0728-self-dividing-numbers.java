class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> arr = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int temp = i;
            boolean isValid = true;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 0 || i % digit != 0) {
                    isValid = false;
                    break;
                }
                temp /= 10;
            }
            if (isValid)
                arr.add(i);
        }
        return arr;
    }
}