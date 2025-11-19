class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List<String> result = new ArrayList<>();
        fun(0,"",digits,map,result);
        return result;
    }

    private void fun(int i, String current, String digits, String[] map, List<String> result) {
        if (i == digits.length()) {
            result.add(current);
            return;
        }
        int digit = digits.charAt(i) - '0';
        String letter = map[digit];
        for (char ch : letter.toCharArray()) {
            fun(i + 1, current + ch, digits, map, result);
        }
    }
}