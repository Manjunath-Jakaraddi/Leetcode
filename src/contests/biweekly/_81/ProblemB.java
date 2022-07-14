package contests.biweekly._81;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemB {
    List<Integer>[] adj;
    int[] visited;

    public long countPairs1(int N, int[][] edges) {
        adj = new ArrayList[N];
        visited = new int[N];
        Arrays.fill(visited, -1);
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int e = 0; e < edges.length; e++) {
            int u = edges[e][0];
            int v = edges[e][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int componentNum = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] == -1) {
                dfs1(i, componentNum);
                componentNum++;
            }
        }
        if (componentNum == 1) {
            return 0;
        }
        int[] componentsCount = new int[componentNum];
        for (int i = 0; i < N; i++) {
            componentsCount[visited[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < componentNum - 1; i++) {
            for (int j = i + 1; j < componentNum; j++) {
                ans += (componentsCount[i] * componentsCount[j]);
            }
        }
        return ans;
    }

    private void dfs1(int u, int componentNum) {
        visited[u] = componentNum;
        for (int v : adj[u]) {
            if (visited[v] == -1) {
                dfs1(v, componentNum);
            }
        }
    }

    public long countPairs2(int N, int[][] edges) {
        adj = new ArrayList[N];
        visited = new int[N];
        Arrays.fill(visited, -1);
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int e = 0; e < edges.length; e++) {
            int u = edges[e][0];
            int v = edges[e][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int componentNodes = 0, remainingNodes = N;
        long res = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] == -1) {
                componentNodes = dfs(i);
                res += ((long) componentNodes * remainingNodes);
                remainingNodes -= componentNodes;
            }
        }
        return res;
    }

    private int dfs(int u) {
        visited[u] = 1;
        int nodes = 1;
        for (int v : adj[u]) {
            if (visited[v] == -1) {
                nodes += dfs(v);
            }
        }
        return nodes;
    }
}

/**
 * TODO Revise
 * The first approach works fine, but we are wasting computation
 * by going through n^2 components combinations
 * Instead, we can use dfsComponentsCount * remainingNodes
 *  and then for next remainingNodes subtract dfsComponentsCount
 *  which allows us to calculate in O(n)
 */
