package atcoderdp;

import java.util.Scanner;

public class H_Grid1 {
    private static final int MOD = (int) 1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int[][] dp = new int[N][M];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int row : new int[]{i, i + 1}) {
                    int col = j;
                    if (row == i) {
                        col++;
                    }
                    if (row < N && col < M && grid[i][j] == '.') {
                        dp[row][col] = (dp[row][col] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
