package atcoderdp;

import java.util.Scanner;

public class D_Knapsack0_1 {
    private static final int INF = (int) 1e7+9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), W = sc.nextInt();
        int[] weights = new int[N], values = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        long[] dp = new long[W+1];
        for (int item = 0; item < N; item++) {
            for (int wts = W - weights[item]; wts >= 0; wts--) {
                dp[wts + weights[item]] = Math.max(dp[wts + weights[item]], dp[wts] + values[item]);
            }
        }
        // As the answer can be in any weight we need to find max in the array
        long ans = 0;
        for (int i = 0; i <= W; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
