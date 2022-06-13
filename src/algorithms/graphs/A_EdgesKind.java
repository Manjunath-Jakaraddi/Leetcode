package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A_EdgesKind {
    static final int VISITED = -1, EXPLORED = -2, UNVISITED = -3;
    static int N, E;
    static List<Integer>[] adj;
    static int[] dfs_num, dfs_parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();

        dfs_num = new int[N];
        dfs_parent = new int[N];
        adj = new ArrayList[N];
        Arrays.fill(dfs_num, UNVISITED);
        Arrays.fill(dfs_parent, -1);
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        int x, y;
        for (int i = 0; i < E; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        for (int i = 0; i < N; i++) {
            if (dfs_num[i] == UNVISITED) {
                dfs(i);
            }
        }
    }

    private static void dfs(int u) {
        dfs_num[u] = EXPLORED;
        for (int v : adj[u]) {
            System.out.printf("Edge (%d %d) is a ", u, v);
            if (dfs_num[v] == UNVISITED) {
                System.out.println("Tree Edge");
                dfs_parent[v] = u;
                dfs(v);
            } else if (dfs_num[v] == EXPLORED) {
                if (v == dfs_parent[u]) {
                    System.out.println("Bi-directional edge");
                } else {
                    System.out.println("Back Edge (Cycle)");
                }
            } else if (dfs_num[v] == VISITED) {
                System.out.println("Forward/Cross Edge");
            }
        }
        dfs_num[u] = VISITED;
    }
}
