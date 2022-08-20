package codeforces.contests.educational._1716;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProblemC {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static boolean[][] vis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            N = 2;
            M = sc.nextInt();
            int[][] arr = new int[N][M];
            vis = new boolean[N][M];
            for (int i=0; i<M; i++) {
                arr[0][i] = sc.nextInt();
            }
            for (int i=0; i<M; i++) {
                arr[1][i] = sc.nextInt();
            }
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {0, 0, 0});
            vis[0][0] = true;
            int currTime = 0;
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                currTime = curr[2];
                int[] next = new int[] {-1, -1, Integer.MAX_VALUE};
                boolean added = false;
                for (int i=0; i<4; i++) {
                    int nx = curr[0] + dx[i], ny = curr[1] + dy[i];
                    if (isValid(nx, ny)) {
                        if (arr[nx][ny] <= currTime) {
                            vis[nx][ny] = true;
                            q.add(new int[] { nx, ny, currTime + 1});
                            added = true;
                            break;
                        } else if (next[2] > arr[nx][ny]) {
                            next[2] = arr[nx][ny] + 1;
                            next[0] = nx;
                            next[1] = ny;
                        }
                    }
                }
                if (!added && next[0] != -1) {
                    vis[next[0]][next[1]] = true;
                    q.add(next);
                }
            }
            System.out.println(currTime);
        }
    }

    static boolean isValid(int x, int y) {
        return (x >=0 && x < N && y >=0 && y < M && !vis[x][y]);
    }
}
