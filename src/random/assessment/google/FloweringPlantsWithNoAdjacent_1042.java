package random.assessment.google;

import java.util.*;

public class FloweringPlantsWithNoAdjacent_1042 {
    int[] res;
    Map<Integer, Set<Integer>> map;

    /**
     * As in the question it is mentioned all the nodes have atmost 3 adjacent nodes,
     * and we have 4 color options, so we should always be able to pick atleast one
     * color to color for each of the nodes.
     */
    public int[] gardenNoAdjOptimized(int N, int[][] paths) {
        map = new HashMap<>();
        for (int[] p : paths) {
            p[0]--;
            p[1]--;
            map.putIfAbsent(p[0], new HashSet<>());
            map.putIfAbsent(p[1], new HashSet<>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        res = new int[N];
        for (int i=0; i<N; i++) {
            int[] colors = new int[5];
            for (int j : map.getOrDefault(i, new HashSet<>())) {
                colors[res[j]] = 1;
            }
            for (int c=4; c>0; c--) {
                if (colors[c] == 0) {
                    res[i] = c;
                }
            }
        }
        return res;
    }

    public int[] gardenNoAdjMine(int n, int[][] paths) {
        map = new HashMap<>();
        for (int[] p : paths) {
            p[0]--;
            p[1]--;
            map.putIfAbsent(p[0], new HashSet<>());
            map.putIfAbsent(p[1], new HashSet<>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }
        res = new int[n];
        Arrays.fill(res, -1);
        for (int i=0; i<n; i++) {
            if (res[i] == -1) {
                dfs(i);
            }
        }
        for (int i=0; i<n; i++) {
            res[i]++;
        }
        return res;
    }

    void dfs(int u) {
        int color = 0;
        for (color = 0; color < 4; color++) {
            boolean found = false;
            for (int v : map.getOrDefault(u, new HashSet<>())) {
                if (res[v] == color) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        res[u] = color;
        for (int v : map.getOrDefault(u, new HashSet<>())) {
            if (res[v] == -1) {
                dfs(v);
            }
        }
    }
}
