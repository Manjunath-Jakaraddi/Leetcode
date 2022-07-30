package leetcodedp.StockPrice;

public class _3_Atmost2Trasactions {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N <= 1) {
            return 0;
        }

        int leftMin = Integer.MAX_VALUE, rightMax = 0;
        int[] leftProfits = new int[N], rightProfits = new int[N];
        for (int l = 0; l < N; l++) {
            leftMin = Math.min(leftMin, prices[l]);
            leftProfits[l] = Math.max(l > 0 ? leftProfits[l-1] : 0, prices[l] - leftMin);

            int r = N - 1 - l;
            rightMax = Math.max(rightMax, prices[r]);
            rightProfits[r] = Math.max(r < N - 1 ? rightProfits[r+1] : 0, rightMax - prices[r]);
        }
        int maxProfit = 0;
        for (int i = 0; i < N-1; i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i]);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int t1Cost = Integer.MAX_VALUE,
                t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0,
                t2Profit = 0;
        for (int price : prices) {
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);

            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }
        return t2Profit;
    }
}
