package company.infosys;

import java.util.Scanner;

public class GridPath {
    private static int MOD = (int) 1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][2];
        for (int i = 0; i < N; i++) {
            grid[i][0] = sc.nextInt();
            grid[i][1] = sc.nextInt();
        }
        int[][] dp = new int[N][2];
        dp[0][0] = grid[0][0];
        dp[0][1] = grid[0][1];
        int res = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < N; i++) {
            boolean found = false;
            for (int curr = 0; curr < 2; curr++) {
                for (int prev = 0; prev < 2; prev++) {
                    if (grid[i][curr] > grid[i-1][prev]) {
                        dp[i][curr] = Math.max((grid[i][curr] + dp[i-1][prev]) % MOD, dp[i][curr]);
                        res = Math.max(res, dp[i][curr]);
                        found = true;
                    }
                }
            }
            if (!found) {
                break;
            }
        }
        System.out.println(res);
    }
}
