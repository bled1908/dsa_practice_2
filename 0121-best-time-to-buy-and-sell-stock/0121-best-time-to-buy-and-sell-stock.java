class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int mProfit = 0;
        for(int price: prices) {
            if(price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > mProfit) {
                mProfit = price - minPrice;
            }
        }
        return mProfit;
    }
}