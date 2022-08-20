package random.graphs;

import java.util.ArrayList;
import java.util.List;

public class NumOfConnectedComponents_323 {
    int N;
    List<Integer>[] adj;
    boolean[] vis;
    public int countComponents(int n, int[][] edges) {
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
        int res = 0;
        for (int i=0; i<N; i++) {
            if (!vis[i]) {
                res++;
                dfs(i);
            }
        }
        return res;
    }

    void dfs(int u) {
        vis[u] = true;
        for (int v : adj[u]) {
            if (!vis[v]) {
                dfs(v);
            }
        }
    }
}
