package random.graphs;

public class MaxAreaOfIslands {
    int[] dx = {-1, 1,  0, 0};
    int[] dy = { 0, 0, -1, 1};
    int[][] grid;
    int N = 0, M = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        N = grid.length;
        M = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    int dfs(int x, int y) {
        grid[x][y] = 0;
        int count = 1;
        for (int i=0; i<4; i++) {
            if(isValid(x+dx[i], y+dy[i])) {
                count += dfs(x+dx[i], y+dy[i]);
            }
        }
        return count;
    }

    boolean isValid(int x, int y) {
        return (x >=0 && x<N && y>=0 && y<M && grid[x][y] == 1);
    }
}
