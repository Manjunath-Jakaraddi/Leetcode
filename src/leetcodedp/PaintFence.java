package leetcodedp;

public class PaintFence {
    public int numWaysMLE(int N, int K) {
        // n -> (1,50) k -> (1, 10^5)
        int[][][] dp = new int[N+1][K][K];
        if (N == 1) {
            return K;
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                dp[2][i][j] = 1;
            }
        }
        for (int i = 3; i <= N; i++) {
            for (int curr = 0; curr < K; curr++) {
                for (int prev = 0; prev < K; prev++) {
                    for (int prev2 = 0; prev2 < K; prev2++) {
                        if (prev == curr && prev == prev2)  continue;
                        dp[i][curr][prev] += dp[i-1][prev][prev2];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                res += dp[N][i][j];
            }
        }
        return res;
    }

    public int numWaysSpaceSaving(int N, int K) {
        int[][] prevDp = new int[K][K], nextDp = new int[K][K], temp;
        if (N == 1) {
            return K;
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                prevDp[i][j] = 1;
            }
        }
        for (int i = 3; i <= N; i++) {
            for (int curr = 0; curr < K; curr++) {
                for (int prev = 0; prev < K; prev++) {
                    for (int prev2 = 0; prev2 < K; prev2++) {
                        if (prev == curr && prev == prev2)  continue;
                        nextDp[curr][prev] += prevDp[prev][prev2];
                    }
                }
            }
            temp = prevDp;
            prevDp = nextDp;
            nextDp = temp;
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < K; k++) {
                    nextDp[j][k] = 0;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                res += prevDp[i][j];
            }
        }
        return res;
    }
}
