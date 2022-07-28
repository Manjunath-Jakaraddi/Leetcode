package contests.weekly._300;

import java.util.Arrays;

public class ProblemD {
    public static void main(String[] args) {
        int[][] grid = {{1},{2}};
        Solver2 solver = new Solver2();
        System.out.println(solver.countPaths(grid));
    }
}

class Solver1 {
    int N, M;
    int[][] grid, cnt, visited;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    int MOD = (int) 1e9+7;
    int res;
    public int countPaths(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        this.grid = grid;
        cnt = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cnt[i], 1);
        }
        res = (N * M) % MOD;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y) {
        visited[x][y] = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (isValid(nx, ny) && grid[nx][ny] > grid[x][y]) {
                if (visited[nx][ny] == 0) {
                    dfs(nx, ny);
                }
                res = (res + cnt[nx][ny]) % MOD;
                cnt[x][y] = (cnt[x][y] + cnt[nx][ny]) % MOD;
            }
        }
    }
    private boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}

class Solver2 {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    int MOD = (int) 1e9+7;
    int N, M, res;
    int[][] grid, dp;
    public int countPaths(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        dp = new int[N][M];
        this.grid = grid;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res = (res + dfs(i, j)) % MOD;
            }
        }
        return res;
    }

    private int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int cnt = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (isValid(nx, ny) && grid[nx][ny] > grid[x][y]) {
                cnt = (cnt + dfs(nx, ny)) % MOD;
            }
        }
        dp[x][y] = cnt;
        return cnt;
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}