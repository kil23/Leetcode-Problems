class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        int len = prices.length;

        if(len == 0) return 0;

        int boughtPrice = prices[0];
        for(int i=0; i<len; i++) {
            if(prices[i] > boughtPrice) {
                if(result < prices[i] - boughtPrice) {
                    result = prices[i] - boughtPrice;
                }
            }else {
                boughtPrice = prices[i];
            }
        }
        return result;
    }
}