class Solution {
    public int maxProfit(int[] prices) {
        int prof = 0;
        int min = prices[0];

        for(int i = 0; i < prices.length-1;i++){
            if (min <= prices[i+1]) prof+=prices[i+1]-min;
            min = prices[i+1];
        }
        

    return prof;
}
}