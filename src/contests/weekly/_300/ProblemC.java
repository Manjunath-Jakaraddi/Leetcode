package contests.weekly._300;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemC {
    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecretDP2D(6, 2, 4));
        System.out.println(peopleAwareOfSecretDP2D(4, 1, 3));
    }

    static int MOD = (int) 1e9 + 7;

    public static int peopleAwareOfSecretDP2D(int N, int delay, int forget) {
        int[][] dp = new int[N + 1][forget + 1];
        dp[1][1] = 1;
        for (int day = 1; day <= N; day++) {
            for (int d = delay; d < forget; d++) {
                dp[day][1] = (dp[day][1] + dp[day - 1][d]) % MOD;
            }
            for (int rememberDays = 1; rememberDays < forget; rememberDays++) {
                dp[day][rememberDays + 1] = dp[day - 1][rememberDays];
            }
        }
        int res = 0;
        for (int i = 0; i <= forget; i++) {
            res = (res + dp[N][i]) % MOD;
        }
        return res;
    }

    public static int peopleAwareOfSecret(int N, int delay, int forget) {
        int sharing = 0;
        Deque<Integer> d = new ArrayDeque<>(), f = new ArrayDeque<>();
        d.add(1);
        f.add(1);
        while (N-- >= 0) {
            if (d.size() >= delay) {
                sharing = (sharing + d.getFirst()) % MOD;
                d.pollFirst();
            }
            if (f.size() >= forget) {
                sharing = (sharing - d.getFirst() + MOD) % MOD;
                d.pollFirst();
            }
            d.add(sharing);
            f.add(sharing);
        }
        return sharing;
    }
}
// (day, personday)
/**
 * Awesome job solving it in 2-D dp in O(N^2)
 * Now optimize it using two queues approach or the rotating array
 */
