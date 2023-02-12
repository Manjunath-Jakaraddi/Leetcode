package cp4.dp;

import java.util.Arrays;

public class TSP {
    static int[][] dist;
    static int[][] memo;
    public static void main(String[] args) {
        dist = new int[][]{
                {0,  20, 42, 35},
                {20, 0,  30, 34},
                {42, 30,  0, 12},
                {35, 34, 12,  0}
        };
        int N = dist.length;
        memo = new int[N][(1<<N)];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(dp(0, (1<<N)-2));
    }

    static int dp(int u, int mask) {
        System.out.print(u + " ");
        for (int i = 3; i >= 0; i--) {
            if ((mask & (1 << i)) > 0) {
                System.out.print(i);
            }
        }
        System.out.println();
        if (mask == 0)  return dist[u][0];
        if (memo[u][mask] != -1)    return memo[u][mask];
        int ans = (int) 2e9+5;
        int m = mask;
        while (m > 0) {
            int twoPowV = Integer.lowestOneBit(m);
            int v = Integer.numberOfTrailingZeros(twoPowV);
            ans = Math.min(ans, dist[u][v] + dp(v, mask^twoPowV));
            m -= twoPowV;
        }
        memo[u][mask] = ans;
        return ans;
    }
}
