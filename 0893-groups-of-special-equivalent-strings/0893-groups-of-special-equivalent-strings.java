import java.util.HashSet;

class Solution {
    public int numSpecialEquivGroups(String[] words) {
        HashSet<Integer> uniques = new HashSet<>();
        for (String word : words) uniques.add(customHash(word));
        return uniques.size();
    }
    private int customHash(String word) {
        int[] evenFreqs = new int[26], oddFreqs = new int[26];
        byte[] chars = word.getBytes();

        int n = chars.length;
        for (int i = 0, limit = n / 2 * 2; i < limit; i += 2) {
            ++evenFreqs[chars[i] - 'a'];
            ++oddFreqs[chars[i + 1] - 'a'];
        }
        if (n % 2 == 1) ++evenFreqs[chars[n - 1] - 'a'];
        int acc = 0;
        for (int i = 0; i < 26; ++i) {
            acc = 31 * acc + evenFreqs[i];
            acc = 31 * acc + oddFreqs[i];
        }
        return acc;
    }
}