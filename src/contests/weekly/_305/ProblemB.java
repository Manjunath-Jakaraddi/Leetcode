package contests.weekly._305;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemB {
    List<Integer>[] adj;
    int N, E;
    int[] vis;
    Map<Integer, Boolean> rmap;

    public int reachableNodes(int N, int[][] edges, int[] restricted) {
        adj = new List[N];
        this.N = N;
        this.E = edges.length;
        this.vis = new int[N];
        rmap = new HashMap<>();
        for (int i=0; i<N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int num : restricted) {
            rmap.put(num, true);
        }

        for (int i=0; i<E; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        return dfs(0);
    }

    private int dfs(int u) {
        vis[u] = 1;
        int cnt = 1;
        for (int v : adj[u]) {
            if (!rmap.containsKey(v) && vis[v] == 0) {
                cnt += dfs(v);
            }
        }
        return cnt;
    }
}
