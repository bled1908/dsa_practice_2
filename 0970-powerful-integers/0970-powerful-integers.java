class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        for (int xi = 1; xi < bound; xi *= x) {
            for (int yj = 1; xi + yj <= bound; yj *= y) {
                ans.add(xi + yj);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<Integer>(ans);
    }
}