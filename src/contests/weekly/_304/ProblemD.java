package contests.weekly._304;

public class ProblemD {
    int[] vis, edges, dist;
    int res = -1;
    void dfs(int u) {
        if (edges[u] == -1) {
            return;
        }
        if (vis[edges[u]] == 0) {
            vis[edges[u]] = 1;
            dist[edges[u]] = dist[u] + 1;
            dfs(edges[u]);
            vis[edges[u]] = 2;
        } else if (vis[edges[u]] == 1) {
            res = Math.max(res, dist[u] - dist[edges[u]] + 1);
        }
    }

    public int longestCycle(int[] edges) {
        this.edges = edges;
        vis = new int[edges.length];
        dist = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                dist[i] = 0;
                dfs(i);
                vis[i] = 2;
            }
        }
        return res;
    }
}
