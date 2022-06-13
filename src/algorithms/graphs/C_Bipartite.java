package algorithms.graphs;

import java.util.*;

public class C_Bipartite {
    static final int UNVISITED = -3, EXPLORED = -2, VISITED = -1;
    static int V, E;
    static List<Integer>[] adj;
    static int[] color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt(); E = sc.nextInt();

        init();

        int x, y;
        for (int i = 0; i < V; i++) {
            x = sc.nextInt(); y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int root = 0;
        queue.add(root);
        color[root] = 0;
        boolean isBipartite = true;
        while (!queue.isEmpty() && isBipartite) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (color[v] == UNVISITED) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (color[u] == color[v]) {
                    isBipartite = false;
                    break;
                }
            }
        }

        System.out.println("The graph is " + (isBipartite ? "Bipartite" : "not Bipartite"));
    }

    private static void init() {
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        color = new int[V];
        Arrays.fill(color, UNVISITED);
    }
}
/**
 * 5
 * 5
 * 0 1
 * 1 2
 * 1 3
 * 2 3
 * 3 4
 * The graph is not Bipartite
 *
 * 5
 * 5
 * 0 1
 * 1 2
 * 2 4
 * 3 4
 * 1 3
 * The graph is Bipartite
 */