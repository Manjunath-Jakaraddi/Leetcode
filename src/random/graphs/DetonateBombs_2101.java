package random.graphs;

import java.util.*;

public class DetonateBombs_2101 {
    Map<Integer, Set<Integer>> map;
    int N;
    int[] vis;
    public int maximumDetonation(int[][] bombs) {
        map = new HashMap<>();
        N = bombs.length;
        for (int i=0; i<N; i++) {
            int[] f= bombs[i];
            for (int j=0; j<N; j++) {
                if (i == j) continue;
                int[] s = bombs[j];
                long dist = (((long)(f[0] - s[0])) * ((long)(f[0] - s[0]))) +
                        (((long)(f[1] - s[1])) * ((long)(f[1] - s[1])));
                if (dist <= ((long)f[2] * f[2])) {
                    map.putIfAbsent(i, new HashSet<>());
                    map.get(i).add(j);
                }
            }
        }

        int res = 0;
        vis = new int[N];
        for (int i=0; i<N; i++) {
            Arrays.fill(vis, 0);
            res = Math.max(res, dfs(i));
        }
        return res;
    }

    int dfs(int u) {
        vis[u] = 1;
        int count = 1;
        for (int v : map.getOrDefault(u, new HashSet<>())) {
            if (vis[v] == 0) {
                count += dfs(v);
            }
        }
        return count;
    }
}
