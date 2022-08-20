package contests.weekly._305;

import java.util.Arrays;

public class ProblemD {
    public int longestIdealStringMine(String s, int k) {
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
        int N = s.length();
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        char[] str = s.toCharArray();
        int res = 1;
        for (int i = 0; i < N; i++) {
            for(int j = Math.max('a', str[i] - k); j <= Math.min('z', str[i] + k); j++) {
                if (prev[j] != -1) {
                    dp[i] = Math.max(dp[prev[j]] + 1, dp[i]);
                    res = Math.max(res, dp[i]);
                }
            }
            prev[str[i]] = i;
        }
        return res;
    }


    public int longestIdealString(String s, int k) {
        int[] prev = new int[256];
        Arrays.fill(prev, 1);
        int N = s.length();
        char[] str = s.toCharArray();
        int res = 1;
        for (int i = 0; i < N; i++) {
            int mx = 0;
            for(int j = Math.max('a', str[i] - k); j <= Math.min('z', str[i] + k); j++) {
                if (prev[j] != -1) {
                    mx = Math.max(prev[j], mx);
                }
            }
            prev[str[i]] = 1 + mx;
            res = Math.max(res, prev[str[i]]);
        }
        return res;
    }
}

/**
 * No need of the dp array can be done with only the prev array by tracking the per character maximum length
 */