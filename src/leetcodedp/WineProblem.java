package leetcodedp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WineProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i=0; i<N; i++) {
            p[i] = sc.nextInt();
        }


        int[][] dp = new int[N][N];
        for (int i=0; i<N; i++) {
            dp[i][i] = p[i] * N;
        }

        int ans = 0;
        for (int l=N-1;l>=0; l--) {
            for (int r=l+1; r<N; r++) {
                int y = N - (r - l);
                dp[l][r] = Math.max(p[l] * y + dp[l+1][r], p[r] * y + dp[l][r-1]);
                ans = Math.max(ans, dp[l][r]);
            }
        }
        System.out.println(ans);
        int[] arr = new int[5];
    }
}
