package atcoderdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class G_LongestPath {
    private static int[] visited;
    private static List<Integer>[] adj;
    private static int[] inDeg;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), E = sc.nextInt();
        int x, y;
        adj = new List[N];
        inDeg = new int[N];
        visited = new int[N];

        Arrays.fill(visited, -1);

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            x--; y--;
            adj[x].add(y);
            inDeg[y]++;
        }

        for (int i = 0; i < N; i++) {
            if (inDeg[i] == 0) {
                dfs(i);
            }
        }

        int res = -1;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, visited[i]);
        }
        System.out.println(res);
    }

    private static void dfs(int curr) {
        visited[curr] = 0;
        for (int child : adj[curr]) {
            if (visited[child] == -1) {
                dfs(child);
            }
            visited[curr] = Math.max(visited[curr], 1 + visited[child]);
        }
    }
}
