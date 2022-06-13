package algorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// For directed graphs
public class E_1KosarajuSCC {
    static final int UNVISITED = -3, EXPLORED = -2, VISITED = -1;
    static int N, E, numSCC;
    static List<Integer>[] adj, adjT;
    static int[] dfs_num, scc_num;
    static List<Integer> S = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); E = sc.nextInt();

        init();

        int x, y;
        for (int i = 0; i < E; i++) {
            x = sc.nextInt(); y = sc.nextInt();
            adj[x].add(y);
            adjT[y].add(x);
        }

        for (int i = 0; i < N; i++) {
            if (dfs_num[i] == UNVISITED) {
                kosaraju(i, 1);
            }
        }

        Arrays.fill(dfs_num, UNVISITED);
        for (int i = N-1; i >= 0; i--) {
            if (dfs_num[S.get(i)] == UNVISITED) {
                ++numSCC;
                kosaraju(S.get(i), 2);
            }
        }

        System.out.printf("There are %d SCCs\n", numSCC);
        System.out.println("They are : ");
        for (int i = 0; i < N; i++) {
            System.out.printf("%d : %d \n", i, scc_num[i]);
        }
    }

    // pass 1 - original, 2 - transpose
    private static void kosaraju(int u, int pass) {
        dfs_num[u] = VISITED;
        List<Integer> neighbour = (pass == 1) ? adj[u] : adjT[u];
        for (int v : neighbour) {
            if (dfs_num[v] == UNVISITED) {
                kosaraju(v, pass);
            }
        }
        if (pass == 1)  S.add(u);
        else scc_num[u] = numSCC;
    }

    private static void init() {
        adj = new ArrayList[N];
        adjT = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            adjT[i] = new ArrayList<>();
        }
        dfs_num = new int[N];
        scc_num = new int[N];
        Arrays.fill(dfs_num, UNVISITED);
        Arrays.fill(scc_num, -1);
    }
}
