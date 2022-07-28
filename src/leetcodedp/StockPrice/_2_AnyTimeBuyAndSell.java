package leetcodedp.StockPrice;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class _2_AnyTimeBuyAndSell {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i=1; i<prices.length; i++) {
            res += Math.max(0, prices[i]-prices[i-1]);
        }
        return res;
    }
}
