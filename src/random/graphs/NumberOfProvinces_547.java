package random.graphs;

public class NumberOfProvinces_547 {

    int[][] mat;
    int N, M;
    public int findCircleNum(int[][] isConnected) {
        this.mat = isConnected;
        N = mat.length;
        M = mat[0].length;
        int res = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (mat[i][j] == 1) {
                    res++;
                    mat[i][j] = 0;
                    mat[j][i] = 0;
                    dfs(j);
                }
            }
        }
        return res;
    }

    void dfs(int c) {
        for (int n=0; n<M; n++) {
            if (mat[c][n] == 1) {
                mat[c][n] = 0;
                mat[n][c] = 0;
                dfs(n);
            }
        }
    }
}
