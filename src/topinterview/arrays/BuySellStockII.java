package topinterview.arrays;


// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
public class BuySellStockII {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0; i<prices.length-1; i++) {
            if(prices[i] < prices[i+1]) {
                profit += (prices[i+1] - prices[i]);
            }
        }
        return profit;
    }
}
