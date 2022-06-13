package contests.weekly._292;

public class ProblemC_2266 {
    int MOD = 1000000007;
    int countTexts(String pressedKeys) {
        int N = pressedKeys.length();
        long[] dp3 = new long[N+1];
        long[] dp4 = new long[N+1];
        dp3[0] = 1;
        dp4[0] = 1;
        // dp for 3 characters
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    dp3[i] = (dp3[i] + dp3[i-j]) % MOD;
                }
            }
        }

        // dp for 2 characters
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i - j >= 0) {
                    dp4[i] = (dp4[i] + dp4[i-j]) % MOD;
                }
            }
        }

        long res = 1;
        int cnt = 0;
        char ch = pressedKeys.charAt(0);
        int ind = 0;
        // group all similar count and multiply possibilities
        while (ind < N) {
            if (pressedKeys.charAt(ind) == ch) {
                cnt++;
            } else {
                if (ch == '7' || ch == '9') {
                    res = (res * dp4[cnt]) % MOD;
                } else {
                    res = (res * dp3[cnt]) % MOD;
                }
                cnt = 1;
                ch = pressedKeys.charAt(ind);
            }
            ind++;
        }
        if (ch == '7' || ch == '9') {
            res = (res * dp4[cnt]) % MOD;
        } else {
            res = (res * dp3[cnt]) % MOD;
        }
        return (int)res;
    }

    // Change character state transition can be obtained by copying the previous states
    // So continuous dp with all in one

    public int countTextsDP(String pressedKeys) {
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            char c = pressedKeys.charAt(i - 1);
            dp[i] = dp[i - 1];
            if (i >= 2) {
                if (c == pressedKeys.charAt(i - 2)) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                    if (i >= 3 && c == pressedKeys.charAt(i - 3)) {
                        dp[i] = (dp[i] + dp[i - 3]) % MOD;
                        if ((c == '7' || c == '9') && i >= 4 && c == pressedKeys.charAt(i - 4)) {
                            dp[i] = (dp[i] + dp[i - 4]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[n];
    }
}
