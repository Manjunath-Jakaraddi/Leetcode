package random.graphs;

import java.util.ArrayDeque;

public class RottenOrange_994 {
    int[] dx = {-1, 0,  1, 0};
    int[] dy = { 0, -1, 0, 1};
    int[][] grid;
    int N, M;
    public int orangesRotting(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        this.grid = grid;
        int fresh = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j,0});
                }
                if (grid[i][j] == 1) fresh++;
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.pollFirst();
            for (int i=0; i<4; i++) {
                int[] next = new int[3];
                next[0] = curr[0] + dx[i];
                next[1] = curr[1] + dy[i];
                next[2] = curr[2] + 1;
                if (isValid(next[0], next[1])) {
                    grid[next[0]][next[1]] = 2;
                    fresh--;
                    if (fresh == 0) {
                        return next[2];
                    }
                    q.add(next);
                }
            }

        }
        if (fresh > 0)
            return -1;
        else
            return 0;
    }


    boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == 1);
    }
}
