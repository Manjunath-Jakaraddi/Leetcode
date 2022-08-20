package contests.weekly._306;

public class ProblemA {
    public int[][] largestLocal(int[][] grid) {
        int N = grid.length;
        int[][] maxLocal = new int[N-2][N-2];
        for (int i=1; i<N-1; i++) {
            for(int j=1; j<N-1; j++) {
                int mx = -1;
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        int nx = i+x, ny = j+y;
                        mx = Math.max(mx, grid[nx][ny]);
                    }
                }
                maxLocal[i-1][j-1] = mx;
            }
        }
        return maxLocal;
    }
}
