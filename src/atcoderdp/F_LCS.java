package atcoderdp;

import java.util.Scanner;

public class F_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine(), b = sc.nextLine();
        int N = a.length(), M = b.length();
        int[][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int x = N, y = M;
        while (x > 0 && y > 0) {
            if (a.charAt(x - 1) == b.charAt(y - 1) && dp[x - 1][y - 1] == dp[x][y] - 1) {
                sb.append(a.charAt(x - 1));
                x--;
                y--;
            } else if (dp[x - 1][y] == dp[x][y]) {
                x--;
            } else {
                y--;
            }
        }
        System.out.println(sb.reverse());
    }
}

