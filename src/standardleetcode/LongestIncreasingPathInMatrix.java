package standardleetcode;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    int MOD = (int) 1e9+7;
    int N, M, res;
    int[][] grid, dp;
    public int longestIncreasingPath(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        dp = new int[N][M];
        this.grid = grid;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j);
            }
        }
        return res;
    }

    private int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int mx = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (isValid(nx, ny) && grid[nx][ny] > grid[x][y]) {
                mx = Math.max(mx, 1 + dfs(nx, ny));
            }
        }
        dp[x][y] = mx;
        res = Math.max(dp[x][y], res);
        return mx;
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}

/**
 * Similar to weekly contest 300 Problem D (taken inspiration from that)
 */