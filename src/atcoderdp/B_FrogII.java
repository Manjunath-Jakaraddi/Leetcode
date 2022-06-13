package atcoderdp;

import java.util.Arrays;
import java.util.Scanner;

public class B_FrogII {
    private static int INF = (int) 1e9+9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        int[] dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], Math.abs(heights[i] - heights[i-j]) + dp[i-j]);
                }
            }
        }
        System.out.println(dp[N-1]);
    }
}
