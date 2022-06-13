package atcoderdp;

import java.util.Scanner;

public class C_Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] points = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + points[i-1][k]);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            res = Math.max(res, dp[N][i]);
        }
        System.out.println(res);
    }
}
