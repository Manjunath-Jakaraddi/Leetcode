package contests.weekly._297;

import java.util.Arrays;

public class ProblemC {
    int[] cookies;
    int N, k;
    int[] children;
    int minUnfairness;

    public int distributeCookies1(int[] cookies, int k) {
        this.k = k;
        this.N = cookies.length;
        this.cookies = cookies;
        this.children = new int[k];
        minUnfairness = Integer.MAX_VALUE;
        solve(0, 0);
        return minUnfairness;
    }

    private void solve(int cookieIndex, int prevUnFairness) {
        if (cookieIndex == N) {
            minUnfairness = Math.min(minUnfairness, prevUnFairness);
            return;
        }
        for (int childIndex = 0; childIndex < Math.min(cookieIndex+1, k); childIndex++) {
            children[childIndex] += cookies[cookieIndex];
            solve(cookieIndex+1, Math.max(children[childIndex], prevUnFairness));
            children[childIndex] -= cookies[cookieIndex];
            if (children[childIndex] == 0) {
                break;
            }
        }
    }


    public int distributeCookies2(int[] cookies, int K) {
        int N = cookies.length;
        int[][] dp = new int[K+1][(1<<N)];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] sum = masksSum(cookies, K);
        dp[0][0] = 0;
        for (int person = 1; person <= K; person++) {
            for (int mask = 0; mask < (1 << N); mask++) {
                for (int submask = mask; submask != 0; submask = (mask & (submask - 1))) {
                    dp[person][mask] = Math.min(dp[person][mask],
                            Math.max(sum[submask], dp[person - 1][mask ^ submask]));
                }
            }
        }
        return dp[K][(1<<N)-1];
    }

    public int[] masksSum(int[] cookies, int K) {
        int[] sum = new int[(1<<N)];
        for (int mask = 0; mask < (1 << N); mask++) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    total += cookies[i];
                }
            }
            sum[mask] = total;
        }
        return sum;
    }

}


/**
 * TODO
 * Revise backtrack and dp solution
 * Read about submask iteration https://cp-algorithms.com/algebra/all-submasks.html
 * Solve similar harder problem https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/
 *
 */