package leetcodedp.StockPrice;

public class _4_AtmostKTransactions {
    int[] prices;
    int[][][] memo;
    int K;
    public int maxProfitTopDown(int k, int[] prices) {
        this.prices = prices;
        this.K = k;
        this.memo = new int[prices.length][k][2];
        return solve(0, k, 0);
    }

    int solve(int i, int transactionsRemaining, int holding) {
        if (i == prices.length || transactionsRemaining == 0) {
            return 0;
        }
        if (memo[i][transactionsRemaining][holding] == 0) {
            int doNothing = solve(i+1, transactionsRemaining, holding);
            int doSomething = 0;
            if (holding == 1) {
                doSomething = prices[i] + solve(i+1, transactionsRemaining - 1, 0);
            } else {
                doSomething = -prices[i] + solve(i+1, transactionsRemaining, 1);
            }
            memo[i][transactionsRemaining][holding] = Math.max(doSomething, doNothing);
        }
        return memo[i][transactionsRemaining][holding];
    }

    public int maxProfitBottomUp(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k+1][2];
        int P = prices.length;
        if (P == 0) {
            return 0;
        }
        for (int t = 1; t <= k; t++) {
            dp[0][t][1] = -prices[0];
        }
        for (int i = 1; i < P; i++) {
            for (int t = 1; t <= k; t++) {
                dp[i][t][0] = Math.max(prices[i] + dp[i-1][t][1], dp[i-1][t][0]);
                dp[i][t][1] = Math.max(-prices[i] + dp[i-1][t-1][0], dp[i-1][t][1]);
            }
        }
        int res = 0;
        for (int i = 0; i < P; i++) {
            res = Math.max(res, dp[P-1][k][0]);
            // res = Math.max(res, dp[P-1][k][1]);
            // Not required as it is always disadvantageous to hold a stock on the end day
        }
        return res;
    }
}
