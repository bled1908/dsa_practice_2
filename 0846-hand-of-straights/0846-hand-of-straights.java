class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        int n = hand.length;
        if (n % k != 0) return false;

        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : hand) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int num : hand) {
            if (map.get(num) == 0) continue; // already used

            // try forming a group starting at num
            for (int i = 0; i < k; i++) {
                int curr = num + i;
                if (!map.containsKey(curr) || map.get(curr) == 0) {
                    return false;
                }
                map.put(curr, map.get(curr) - 1);
            }
        }

        return true;
    }
}