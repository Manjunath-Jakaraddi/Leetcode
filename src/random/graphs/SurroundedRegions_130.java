package random.graphs;

public class SurroundedRegions_130 {
    int N, M;
    char[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public void solve(char[][] board) {
        N = board.length;
        M = board[0].length;
        this.board = board;
        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (i==0 || i == N-1 || j == 0 || j == M-1) {
                    if (board[i][j] == 'O') {
                        dfs(i,j);
                    }
                }
            }
        }
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (board[i][j] != 'Z') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(int x, int y) {
        board[x][y] = 'Z';
        for (int i=0; i<4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (isValid(nx, ny)) {
                dfs(nx, ny);
            }
        }
    }

    boolean isValid(int x, int y) {
        return (x >=0 && x < N && y >= 0 && y < M && board[x][y] == 'O');
    }
}
