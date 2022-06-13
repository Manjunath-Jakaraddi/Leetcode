package algorithms.graphs;

import java.util.*;

public class E_2TarjanSCC {
    static final int UNVISITED = -3, EXPLORED = -2, VISITED = -1;
    static int V, E;
    static List<Integer>[] adj;
    static int[] dfs_num, dfs_low, scc_num;
    static boolean[] visited;
    static Stack<Integer> stack;
    static int dfsNumCounter, numSCC;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt(); E = sc.nextInt();

        init();

        int x, y;
        for (int u = 0; u < E; u++) {
            x = sc.nextInt(); y = sc.nextInt();
            adj[x].add(y);
        }

        for (int u = 0; u < V; u++) {
            if (dfs_num[u] == UNVISITED) {
                tarjanSCC(u);
            }
        }

        System.out.printf("There are %d SCCs\n", numSCC);
        System.out.println("They are : ");
        for (int i = 0; i < V; i++) {
            System.out.printf("%d : %d \n", i, scc_num[i]);
        }
    }

    private static void tarjanSCC(int u) {
        dfs_num[u] = dfs_low[u] = dfsNumCounter;
        dfsNumCounter++;
        stack.push(u);
        visited[u] = true;
        for (int v : adj[u]) {
            if (dfs_num[v] == UNVISITED)
                tarjanSCC(v);
            if (visited[v])
                dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
        }

        if (dfs_num[u] == dfs_low[u]) {
            ++numSCC;
            while (true) {
                int v = stack.pop();
                visited[v] = false; // important as to not visit the processed SCC again through leakage node
                scc_num[v] = numSCC; // leakage node is the one which connects two different SCCs
                if (u == v) break;
            }
        }
    }

    private static void init() {
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        dfs_num = new int[V];
        Arrays.fill(dfs_num, UNVISITED);
        dfs_low = new int[V];
        Arrays.fill(dfs_low, -1);
        visited = new boolean[V];
        scc_num = new int[V];
        stack = new Stack<>();
    }
}
/**
 * 8
 * 9
 * 0 1
 * 1 3
 * 3 2
 * 2 1
 * 3 4
 * 4 5
 * 5 7
 * 7 6
 * 6 4
 * There are 3 SCCs
 * They are :
 * 0 : 3
 * 1 : 2
 * 2 : 2
 * 3 : 2
 * 4 : 1
 * 5 : 1
 * 6 : 1
 * 7 : 1
 */