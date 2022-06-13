package algorithms.graphs;

import java.util.*;

// For directed graphs only
public class B_TopologicalSort {
    static final int UNVISITED = -3, EXPLORED = -2, VISITED = -1;
    static int V, E;
    static List<Integer>[] adj;
    static int[] dfs_num, indeg;
    static List<Integer> top_sort;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();   E = sc.nextInt();

        init();

        int x, y;
        for (int i = 0; i < E; i++) {
            x = sc.nextInt(); y = sc.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }

        for (int u = 0; u < V; u++) {
            if (dfs_num[u] == UNVISITED) {
                dfs_top_sort(u);
            }
        }
        Collections.reverse(top_sort);
        print_result(top_sort);

        // Using pq as we want the sorted topological order
        // Use priority Queue if required the sorted topological order
        top_sort.clear();

        bfs_top_sort();

        print_result(top_sort);
    }

    private static void print_result(List<Integer> top_sort) {
        System.out.print("Topological sort : ");
        top_sort.forEach(ele -> System.out.print(ele + " "));
        System.out.println();
    }

    private static void dfs_top_sort(int u) {
        dfs_num[u] = VISITED;
        for (int v : adj[u]) {
            if (dfs_num[v] == UNVISITED) {
                dfs_top_sort(v);
            }
        }
        top_sort.add(u);
    }

    private static void bfs_top_sort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Queue<Integer> pq = new ArrayDeque<>();
        for (int u = 0; u < V; u++) {
            if (indeg[u] == 0) {
                pq.add(u);
            }
        }

        while (!pq.isEmpty()) {
            int u = pq.poll();
            top_sort.add(u);
            for (int v : adj[u]) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    pq.add(v);
                }
            }
        }
    }

    private static void init() {
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList();
        }
        dfs_num = new int[V];
        Arrays.fill(dfs_num, UNVISITED);
        indeg = new int[V];
        top_sort = new ArrayList<>();
    }
}

/**
 * 8
 * 8
 * 0 1
 * 0 2
 * 1 3
 * 2 4
 * 3 4
 * 2 5
 * 7 6
 * 2 3
 * Topological sort : 7 6 0 2 5 1 3 4
 * Topological sort : 0 1 2 3 4 5 7 6
 */