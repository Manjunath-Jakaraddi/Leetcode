package leetcodedp;

import java.util.Arrays;

public class CoinChangeII_518 {
    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
    /**
     * This is wrong as it considers all the combinations differently like 2,2,1 is different from 2,1,2
     * but the problem asks it to be treated the same so
     * in the sorted order coins we will need to remember another stated in the dp
     * that is the last used coin, so we will only generate sorted sequences that are unique
     */
    int[] coins;
    int N;
    int[][] memo;
    public int changeTD(int amount, int[] coins) {
        Arrays.sort(coins);
        this.coins = coins;
        this.N = coins.length;
        this.memo = new int[amount+1][N+1];
        for (int i = 0; i<=amount; i++) {
            Arrays.fill(memo[i], -1);
        }
        return solveTopDown(amount, 0);
    }

    private int solveTopDown(int remainingAmount, int pos) {
        if (remainingAmount == 0) {
            return 1;
        }
        if (remainingAmount < 0) {
            return 0;
        }
        if (pos == N) {
            return 0;
        }
        if (memo[remainingAmount][pos] != -1) {
            return memo[remainingAmount][pos];
        }
        memo[remainingAmount][pos] = solveTopDown(remainingAmount, pos+1) +
                solveTopDown(remainingAmount - coins[pos], pos);
        return  memo[remainingAmount][pos];
    }

    public int change(int amount, int[] coins) {
        int C = coins.length;
        int[][] dp = new int[amount+1][C];
        for (int i = 0; i < C; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int pos = 0; pos < C; pos++) {
                if (i - coins[pos] >= 0) dp[i][pos] += dp[i - coins[pos]][pos];
                if (pos > 0) dp[i][pos] += dp[i][pos - 1];
            }
        }
        return dp[amount][C-1];
    }

}
