package random.graphs;

import java.util.LinkedList;

public class WallsAndGates_286 {
    int N, M;
    int dx[] = { -1, 0,  1, 0 };
    int dy[] = {  0, -1, 0, 1 };
    int[][] rooms;
    public void wallsAndGates(int[][] rooms) {
        N = rooms.length;
        M = rooms[0].length;
        this.rooms = rooms;
        LinkedList<int[]> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i=0; i<4; i++) {
                int[] next = new int[] {curr[0] + dx[i], curr[1] + dy[i]};
                if (isValid(next[0], next[1])) {
                    rooms[next[0]][next[1]] = rooms[curr[0]][curr[1]] + 1;
                    q.add(next);
                }
            }
        }
    }

    boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M && rooms[x][y] == Integer.MAX_VALUE);
    }
}
