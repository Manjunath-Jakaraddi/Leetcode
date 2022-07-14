package standardleetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

// TODO : Revise
public class TrapRainWater3D_407 {
    static int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M;
    public static void main(String[] args) {
        int[][] heights = new int[][] {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println(trapRainWater(heights));
    }

    public static int trapRainWater(int[][] heights) {
        N = heights.length;
        M = (N == 0 ? 0 : heights[0].length);
        int res = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            pq.offer(new int[] {i, 0, heights[i][0]});
            pq.offer(new int[] {i, M-1, heights[i][M-1]});
            visited[i][0] = visited[i][M-1] = true;
        }

        for (int i = 1; i < M; i++) {
            pq.offer(new int[] {0, i, heights[0][i]});
            pq.offer(new int[] {N-1, i, heights[N-1][i]});
            visited[0][i] = visited[N-1][i] = true;
        }

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            for (int[] dir : dirs) {
                int i = cell[0] + dir[0], j = cell[1] + dir[1];
                if (isValid(i, j) && !visited[i][j]) {
                    res += Math.max(0, cell[2] - heights[i][j]);
                    visited[i][j] = true;
                    pq.offer(new int[] {i, j, Math.max(cell[2], heights[i][j])});
                }
            }
        }
        return res;
    }

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

}
