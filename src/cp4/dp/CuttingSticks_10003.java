package cp4.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CuttingSticks_10003 {
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int L = sc.nextInt();
            if (L == 0)
                break;
            int N = sc.nextInt();
            memo = new int[N+1][N+2];
            int[] A = new int[N+2];
            Arrays.fill(memo[0], -1);
            for (int i = 1; i <= N; i++) {
                A[i] = sc.nextInt();
                Arrays.fill(memo[i], -1);
            }
            A[N+1] = L;
            Arrays.fill(memo[N+1], -1);
            System.out.println(solve(0, N+1, A));
        }
    }

    static int solve(int left, int right, int[] A) {
        if (left + 1 == right)  {
            return 0;
        }
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            ans = Math.min(ans, solve(left, i, A) + solve(i, right, A) + A[right] - A[left]);
        }
        memo[left][right] = ans;
        return ans;
    }
}
