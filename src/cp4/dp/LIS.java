package cp4.dp;

import java.util.Arrays;

public class LIS {
    static int MAX_N = 10004;
    static int[] memo = new int[MAX_N];
    static int INF = (int) 1e9 + 5;
    static int[] A;
    public static void main(String[] args) {
        A = new int[11];
        for (int i=0; i<9; i++) {
            A[i] = i+1;
        }
        A[9] = -10;
        for (int i=0; i<10; i++) {
            System.out.print(A[i] + " ");
        }
        A[10] = INF;
        Arrays.fill(memo, -1);
        System.out.println(LIS(10) - 1);
    }

    public static int LIS(int i) {
        if (i == 0)  return 1;
        if (memo[i] != -1)  return memo[i];
        int ans = 1;
        for (int j=0; j<i; j++) {
            if (A[j] < A[i]) {
                ans = Math.max(ans, LIS(j) + 1);
            }
        }
        memo[i] = ans;
        return ans;
    }
}
