package leetcodedp.StockPrice;

public class _5_AnyNoOfTransactionsWithCooldown {
    int[] prices;
    int N;
    int[][][] memo;
    public int maxProfitTopDown(int[] prices) {
        this.N = prices.length;
        this.prices = prices;
        this.memo = new int[N][2][2];
        return solve(0, 0, 0);
    }

    int solve(int i, int holding, int cooldown) {
        if (i == N) {
            return 0;
        }
        if (memo[i][holding][cooldown] == 0) {
            int doNothing = solve(i+1, holding, 0);
            int res = doNothing;

            if (holding == 1) {
                int sell = prices[i] + solve(i+1, 0, 1);
                res = Math.max(res, sell);
            } else {
                if (cooldown == 0) {
                    res = Math.max(res, -prices[i] + solve(i+1, 1, 0));
                }
            }
            memo[i][holding][cooldown] = res;
        }
        return memo[i][holding][cooldown];
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][][] dp = new int[N][2][2];
        dp[0][1][0] = -prices[0];
        for (int i = 1; i < N; i++) {
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][0][1]);
            // need no previous transaction and no stock existing so do nothing with both pt having/not having
            dp[i][0][1] = prices[i] + dp[i-1][1][0];
            // sell something to get the pt and get rid of stock -> should have no pt (not possible to have) on rhs and have pt on lhs
            dp[i][1][0] = Math.max(-prices[i] + dp[i-1][0][0], dp[i-1][1][0]);
            // buy something to get stock or do nothing should have not pt on rhs
        }
        return Math.max(dp[N-1][0][0], dp[N-1][0][1]); // return last elements no holding stocks and both with/without pt
        // no holding stocks as holding stocks on last day is not greedy
    }

    public int maxProfitSpaceSaving(int[] prices) {
        int N = prices.length;
        int[][] prevdp = new int[2][2], nextdp = new int[2][2];
        int[][] temp;
        prevdp[1][0] = -prices[0];
        for (int i = 1; i < N; i++) {
            nextdp[0][0] = Math.max(prevdp[0][0], prevdp[0][1]);
            nextdp[0][1] = prices[i] + prevdp[1][0];
            nextdp[1][0] = Math.max(-prices[i] + prevdp[0][0], prevdp[1][0]);
            temp = prevdp;
            prevdp = nextdp;
            nextdp = temp;
            nextdp[0][0] = 0;
            nextdp[0][1] = 0;
            nextdp[1][0] = 0;
            nextdp[1][1] = 0;
        }
        return Math.max(prevdp[0][0], prevdp[0][1]);
    }

}

/**
 *  (i, holding, previoustransction)
 *  holding == 1 && pt == 0 || ( not possible pt == 1)
 *  sell or donothing
 *
 * holding == 0 && previoustransaction == 1
 *  donothing
 *
 *  holding == 0 and previoustransctopn == 0
 *  buy
 */

/**
 * As only three states are possible draw the states as held, cooldown and sold
 *  then draw the state diagram and the transitions b/w them to understand it more better
 *  eg. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/
 */
