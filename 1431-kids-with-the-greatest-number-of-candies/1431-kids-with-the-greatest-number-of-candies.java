class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = 0;
        for(int num: candies) {
            max = Math.max(max, num);
        }
        for(int candy: candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}