package contests.weekly._295;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ProblemD {
    private static int[] dx = {-1, 1,  0, 0};
    private static int[] dy = { 0, 0, -1, 1};
    private static int N, M;
    private static int INF = 987654321;

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(minimumObstacles(grid));
    }
    private static int minimumObstacles(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        ArrayDeque<int[]> emptyQueue = new ArrayDeque<>(), obstacleQueue = new ArrayDeque<>();
        int res = 0;
        emptyQueue.add(new int[]{0,0});
        while (!emptyQueue.isEmpty() || !obstacleQueue.isEmpty()) {
            if (emptyQueue.isEmpty()) {
                ArrayDeque<int[]> temp = obstacleQueue;
                obstacleQueue = emptyQueue;
                emptyQueue = temp;
                res++;
            }
            int[] curr = emptyQueue.poll();
            if (curr[0] == N-1 && curr[1] == M-1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int[] nxt = {curr[0] + dx[i], curr[1] + dy[i]};
                if (isValid(nxt[0], nxt[1]) && grid[nxt[0]][nxt[1]] != -1) {
                    if (grid[nxt[0]][nxt[1]] == 1) {
                        obstacleQueue.add(nxt);
                    } else {
                        emptyQueue.add(nxt);
                    }
                    grid[nxt[0]][nxt[1]] = -1;
                }
            }
        }
        return res;
    }


    private static int minimumObstacles01BFS(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        N = grid.length;
        M = grid[0].length;
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }
        queue.add(new int[]{0, 0});
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] nxt = {curr[0] + dx[i], curr[1] + dy[i]};
                if (isValid(nxt[0], nxt[1])
                        && dist[nxt[0]][nxt[1]] > (dist[curr[0]][curr[1]] + grid[nxt[0]][nxt[1]])) {
                    dist[nxt[0]][nxt[1]] = dist[curr[0]][curr[1]] + grid[nxt[0]][nxt[1]];
                    // Below steps is important
                    // getting correct ans even though not doing this but will be inefficient
                    // and this will make a difference
                    if (grid[nxt[0]][nxt[1]] == 1) {
                        queue.offerLast(nxt);
                    } else {
                        queue.offerFirst(nxt);
                    }
                }
            }
        }
        return dist[N-1][M-1];
    }

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    // This only works if we are going down and right
    // but for all directions does not work
    // so will have to use 0-1 bfs
    public static int minimumObstaclesDP(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int[][] dp = new int[M+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j-1] + grid[i-1][j-1];
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = dp[i-1][j] + grid[i-1][j-1];
                    continue;
                }
                dp[i][j] = grid[i-1][j-1] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[N][M];
    }
}
