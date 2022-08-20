import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3);
        int[] res = arr.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main2(String[] args) {
        int[][] grid77 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(solve(grid77));
    }

    private static int solve(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int[][] gridWays = new int[N][M];
        assert N == M;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0) {
                    gridWays[i][j] = 1;
                    continue;
                }
                if (grid[i][j] != 0) {
                    continue;
                }
                gridWays[i][j] = gridWays[i-1][j] + gridWays[i][j-1];
            }
        }
        return gridWays[N-1][M-1];
    }
}
