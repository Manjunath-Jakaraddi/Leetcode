package random.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree_261 {
    int N;
    List<Integer>[] adj;
    boolean[] vis;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        N = n;
        vis = new boolean[N];
        adj = new List[N];
        for (int i=0; i<N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return dfs(0) == n;
    }

    int dfs(int u) {
        vis[u] = true;
        int node = 1;
        for (int v : adj[u]) {
            if (!vis[v]) {
                node += dfs(v);
            }
        }
        return node;
    }
}
