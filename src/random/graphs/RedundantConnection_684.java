package random.graphs;

public class RedundantConnection_684 {
    int[] par;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        par = new int[N];
        rank = new int[N];
        int[] res = new int[2];
        for (int i=0; i<N; i++) par[i] = i;
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            if (findSet(u) == findSet(v)) {
                res[0] = u+1;
                res[1] = v+1;
            } else {
                union(u, v);
            }
        }
        return res;
    }

    int findSet(int i) {
        return (par[i] == i) ? i : (par[i] = findSet(par[i]));
    }

    void union(int i, int j) {
        int x = findSet(i), y = findSet(j);
        if (rank[x] > rank[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        par[x] = y;
        if (rank[x] == rank[y]) rank[y]++;
    }
}

/**
 * Can be solved efficiently using the ufds as the dfs cannot find the last
 * edge efficiently (requires to run dfs many times)
 * Also, can speed up the ufds by using the rank heuristic (joining the smaller height ranked
 * tree with the larger one to keep the findSet cost to minimal even after compression)
 */
