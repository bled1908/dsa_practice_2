class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = candies[0];
        int n = candies.length;
        for(int i = 0; i < n; i++){
            greatest = Math.max(greatest, candies[i]);
            candies[i] += extraCandies;
        }
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(candies[i] >= greatest) res.add(true);
            else res.add(false);
        }
        return res;
    }
}