package random.graphs;

public class NumOfIslands_200 {
    int N, M;
    char[][] grid;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int numIslands(char[][] grid) {
        N = grid.length;
        M = grid[0].length;
        this.grid = grid;
        int res = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j);
                }
            }
        }
        return res;
    }

    void dfs(int x, int y) {
        grid[x][y] = '0';
        for (int i=0; i<4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (isValid(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == '1');
    }
}

/**
 * If bfs approach then the space complexity will be less i.e O(min(m,n))
 * To understand imagine all ones and diagonal line exploration in each step of bfs
 * and diagonal elements can cross over min(m,n) elements at max
 * In case of dfs approach the space complexity will be O(m*n)
 */