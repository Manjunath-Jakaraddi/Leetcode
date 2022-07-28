package leetcodedp.StockPrice;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class _1_OneTimeBuyAndSell {
    public int maxProfit(int[] prices) {
        int res = 0, mn = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            mn = Math.min(mn, prices[i]);
            res = Math.max(res, prices[i] - mn);
        }
        return res;
    }
}
