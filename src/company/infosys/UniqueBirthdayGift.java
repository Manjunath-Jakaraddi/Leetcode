package company.infosys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniqueBirthdayGift {
    static int MOD = (int) 1e9+7;
    private static List<Integer>[] factors;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        factors = new List[N+1];
        for (int i = 0; i <= N; i++) {
            factors[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            findFactors(i);
        }
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int seq = 2; seq <= K; seq++) {
            for (int i = 1; i <= N; i++) {
                for (int fact : factors[i]) {
                    dp[seq][i] = (dp[seq][i] + dp[seq-1][fact]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = (res + dp[K][i]) % MOD;
        }
        System.out.println(res);
    }

    private static void findFactors(int N) {
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i * i == N) {
                    factors[N].add(i);
                } else {
                    factors[N].add(i);
                    factors[N].add(N/i);
                }
            }
        }
    }
}
