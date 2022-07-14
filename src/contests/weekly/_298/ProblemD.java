package contests.weekly._298;

public class ProblemD {
    public long sellingWood(int N, int M, int[][] prices) {
        int[][] dp = new int[N+1][M+1];
        int P = prices.length;
        for (int p = 0; p < P; p++) {
            dp[prices[p][0]][prices[p][1]] = prices[p][2];
        }
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                for (int i = 1; i <= col/2; i++) {
                    dp[row][col] = Math.max(dp[row][col], dp[row][i] + dp[row][col-i]);
                }
                for (int i = 1; i <= row/2; i++) {
                    dp[row][col] = Math.max(dp[row][col], dp[i][col] + dp[row-i][col]);
                }
            }
        }
        return dp[N][M];
    }

}

/**
 * TODO: Revise the dp concept (new)
 * The thing to catch in the problem is the entire things gets cuts,
 * so there are not complicated cuts (patterns) it will always be rectangle
 * The possibilities for this are for given 1,4 -> 1,1 + 1,3 or 1,2 + 1,2 (similar for columns)
 * (after 4/2 -> the patterns repeats due to symmetry) so only till half is enough
 */
