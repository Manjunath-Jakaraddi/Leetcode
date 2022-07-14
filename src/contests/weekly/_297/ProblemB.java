package contests.weekly._297;

import java.util.Arrays;

public class ProblemB {

    public static void main(String[] args) {
        int[][] grid = {{5,3},{4,0},{2,1}}, moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        System.out.println(minPathCost(grid, moveCost));
    }
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int N = grid.length;
        int M = (N > 0 ? grid[0].length : 0);
        int nodes = N * M;
        int[] dist = new int[nodes];
        Arrays.fill(dist, 987654321);
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                int src = grid[i][j];
                dist[src] = (dist[src] == 987654321 ? src : dist[src] + src);
            }
            for (int j = 0; j < M; j++) {
                int src = grid[i][j];
                for (int k = 0; k < M; k++) {
                    int dest = grid[i+1][k];
                    dist[dest] = Math.min(dist[src] + moveCost[src][k], dist[dest]);
                }
            }
        }
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            mn = Math.min(mn, dist[grid[N-1][i]] + grid[N-1][i]);
        }
        return mn;
    }
}
