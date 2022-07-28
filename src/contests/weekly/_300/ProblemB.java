package contests.weekly._300;

import java.util.Arrays;

public class ProblemB {
    int N, M;
    int[][] visited;
    int[] dirx = {0, 1, 0, -1};
    int[] diry = {1, 0, -1, 0};

    public int[][] spiralMatrix(int n, int m, ListNode head) {
        N = n;
        M = m;
        int[][] res = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], -1);
        }
        int x = 0, y = 0, d = 0;
        while (head != null) {
            visited[x][y] = 1;
            res[x][y] = head.val;
            head = head.next;
            if (isValid(x + dirx[d], y + diry[d])) {
                x += dirx[d];
                y += diry[d];
            } else {
                d = (d+1) %4;
                x += dirx[d];
                y += diry[d];
            }
        }
        return res;
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M && visited[x][y] == 0);
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

