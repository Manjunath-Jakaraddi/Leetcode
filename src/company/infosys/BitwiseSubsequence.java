package company.infosys;

import java.util.Arrays;
import java.util.Scanner;

public class BitwiseSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (((arr[i] & arr[j]) >> 1) < (arr[i] | arr[j]))) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        System.out.println(res);
    }
}
