package random.assessment.amazon;

import java.util.Arrays;

public class DiceRollTargetSum_1155 {
    private int MOD = (int) 1e9+7;
    int[][] dp;
    public int numRollsToTargetTopDown(int n, int k, int target) {
        dp = new int[33][1001];
        for (int i=0; i<33; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n, k, target, 0, 0);
    }

    int solve(int N, int K, int target, int i, int sum) {
        if (i > N || sum > target) {
            return 0;
        }
        if (i == N && sum == target) {
            return 1;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        int currSum = 0;
        for (int x = 1; x <=K; x++) {
            currSum = (currSum + solve(N, K, target, i+1, sum + x)) % MOD;
        }
        dp[i][sum] = currSum;
        return currSum;
    }

    public int numRollsToTargetBottomUp(int d, int f, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=1; i<=d; i++) {
            for (int k=target; k >= (i == d ? target : 0); k--) {
                dp[k] = 0;
                for (int j=k-1; j>= Math.max(0, k-f); j--) {
                    dp[k] = (dp[k] + dp[j]) % MOD;
                }
            }
        }
        return dp[target];
    }
}
