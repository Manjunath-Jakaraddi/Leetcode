package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D_ArticulationPointsAndBridges {
    static final int UNVISITED = -3, EXPLORED = -2, VISITED = -1;
    static final int INF = (int) 1e9+9;
    static int N, E;
    static List<Integer>[] adj;
    static int[] dfs_num, dfs_low, dfs_parent;
    static boolean[] articulation_point;
    static int dfsCounter, dfsRoot, rootChildren;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();

        init();

        int x, y;
        for (int i = 0; i < E; i++) {
            x = sc.nextInt(); y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        System.out.println("Bridges: ");
        for (int i = 0; i < N; i++) {
            if (dfs_num[i] == UNVISITED) {
                dfsRoot = i;
                rootChildren = 0;
                dfs(i);
                articulation_point[dfsRoot] = (rootChildren > 1);
            }
        }
        System.out.println("Articulation Points");
        for (int i = 0; i < N; i++) {
            if (articulation_point[i]) {
                System.out.printf("Vertex %d\n", i);
            }
        }
    }

    private static void dfs(int u) {
        dfs_num[u] = dfsCounter++;
        dfs_low[u] = dfs_num[u];

        for (int v : adj[u]) {
            if (dfs_num[v] == UNVISITED) {
                dfs_parent[v] = u;
                if (u == dfsRoot)  ++rootChildren;

                dfs(v);

                if (dfs_low[v] >= dfs_num[u]) {
                    articulation_point[u] = true;
                }
                if (dfs_low[v] > dfs_num[u]) {
                    System.out.printf("(%d %d) is a Bridge\n", u, v);
                }
                dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
            } else if (v != dfs_parent[u]) {
                dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
            }
        }
    }

    private static void init() {
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        dfs_num = new int[N];
        dfs_low = new int[N];
        dfs_parent = new int[N];
        articulation_point = new boolean[N];
        Arrays.fill(dfs_num, UNVISITED);
        Arrays.fill(dfs_parent, -1);
    }
}

/**
 * 6
 * 6
 * 0 1
 * 1 2
 * 1 3
 * 1 4
 * 1 5
 * 4 5
 * Bridges:
 * (1 2) is a Bridge
 * (1 3) is a Bridge
 * (0 1) is a Bridge
 * Articulation Points
 * Vertex 1
 */