package random.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {
    int dx[] = { -1, 0,  1, 0 };
    int dy[] = {  0, -1, 0, 1 };
    int N, M;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        N = heights.length;
        M = heights[0].length;
        this.heights = heights;
        boolean[][] preachable = new boolean[N][M];
        boolean[][] areachable = new boolean[N][M];
        for(int i=0; i<N; i++) {
            dfs(i, 0, preachable);
            dfs(i, M-1, areachable);
        }
        for (int j=0; j<M; j++) {
            dfs(0, j, preachable);
            dfs(N-1, j, areachable);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (preachable[i][j] && areachable[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int x, int y, boolean[][] reachable) {
        reachable[x][y] = true;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (isValid(nx, ny, reachable) && heights[x][y] <= heights[nx][ny]) {
                dfs(nx, ny, reachable);
            }
        }
    }

    boolean isValid(int x, int y, boolean[][] reachable) {
        return (x >= 0 && x < N && y >= 0 && y < M && !reachable[x][y]);
    }
}
