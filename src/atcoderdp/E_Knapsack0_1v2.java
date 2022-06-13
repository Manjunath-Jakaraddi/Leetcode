package atcoderdp;

import java.util.Arrays;
import java.util.Scanner;

public class E_Knapsack0_1v2 {
    private static final long INF = (long) 1e18 + 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), W = sc.nextInt();
        int[] values = new int[N], weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        long[] dp = new long[N * 1000 + 5];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int item = 0; item < N; item++) {
            for (int value_already = N*1000 - values[item]; value_already >=0 ; value_already--) {
                dp[value_already + values[item]] = Math.min(dp[value_already + values[item]], dp[value_already] + weights[item]);
            }
        }

        int res = 0;
        for (int i = 1; i < N * 1000 + 5; i++) {
            if (dp[i] <= W) {
                res = Math.max(res, i);
            }
        }
        System.out.println(res);
    }
}
