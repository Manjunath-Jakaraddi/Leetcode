package contests.weekly._306;

public class ProblemD {
    int res = 0;
    int N;
    public int countSpecialNumbersMine(int n) {
        this.N = n;
        solveMine(0, 0);
        return res;
    }

    void solveMine(int mask, int num) {
        if (num > N) {
            return;
        }
        for (int i=1; i<10; i++) {
            if ((mask & (1 << i)) == 0) {
                if ((num + i) <= N) {
                    res++;
                }
                solveMine(mask | (1 << i), (num + i) * 10);
            }
        }
    }

    int[][][] dp;
    public int countSpecialNumbersTopDown(int n) {
        dp = new int[10][1024][2];
        for (int i=0; i < 10; i++) {
            for (int j=0; j<1024; j++) {
                dp[i][j][0] = dp[i][j][1] = -1;
            }
        }
        return solve(0, 0, true, String.valueOf(n)) - 1;
    }

    int solve(int pos, int mask, boolean tight, String num) {
        if (pos == num.length()) {
            return 1;
        }
        int t = (tight ? 1 : 0);
        if (dp[pos][mask][t] != -1) {
            return dp[pos][mask][t];
        }
        int upperDigit = (tight ? (num.charAt(pos) - '0') : 9), count = 0;
        for (int i=0; i<=upperDigit; i++) {
            if ((mask & (1 << i)) == 0) {
                int newMask = (mask == 0 && i == 0 ? mask : (mask | (1 << i)));
                count += solve(pos + 1, newMask, tight && (i  == upperDigit), num);
            }
        }
        dp[pos][mask][t] = count;
        return dp[pos][mask][t];
    }

    public int countSpecialNumbers(int n) {
        int[][][] dp = new int[10][1024][2];
        char[] num = String.valueOf(n).toCharArray();
        int N = num.length;
        int ud = Math.min(num[0] - '0', 9);
        for (int i=0; i<=ud; i++) {
            dp[0][(1<<i)][(i == ud  ? 1 : 0)] = 1;
        }

        for (int p = 1; p < N; p++) {
            for (int mask = 0; mask < (1 << N); mask++) {
                for (int t = 0; t < 2; t++) {
                    ud = Math.min(num[p] - '0', 9);
                    for (int i=0; i<=ud; i++) {
                        if ((mask & (1 << i)) == 0) {
                            if (mask == 0 && i == 0) {
                                dp[p][mask][0] += dp[p - 1][mask][0];
                            } else {
                                int nt = ((t == 1 && i == ud) ? 1 : 0);
                                dp[p][mask][nt] += dp[p-1][mask ^ (1 << i)][t];
                            }
                        }
                    }
                }
            }
        }
        return dp[N-1][((1 << N) - 1)][1];
    }
}
