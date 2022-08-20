package random.graphs;

import java.util.*;

public class ValidArrangementOfPairs_2097 {
    int E;
    Map<Integer, List<Integer>> adj;
    Map<Integer, Integer> indeg, outdeg;
    LinkedList<Integer> res;
    public int[][] validArrangement(int[][] pairs) {
        E = pairs.length;
        adj = new HashMap<>();
        indeg = new HashMap<>();
        outdeg = new HashMap<>();
        for(int[] p : pairs) {
            if (!indeg.containsKey(p[0])) {
                indeg.put(p[0], 0);
            }
            if (!outdeg.containsKey(p[1])) {
                outdeg.put(p[1], 0);
            }
            outdeg.put(p[0], outdeg.getOrDefault(p[0], 0) + 1);
            indeg.put(p[1], indeg.getOrDefault(p[1], 0) + 1);
            if (!adj.containsKey(p[0])) {
                adj.put(p[0], new ArrayList<>());
            }
            adj.get(p[0]).add(p[1]);
        }
        int start = pairs[0][0];
        for (int ele : outdeg.keySet()) {
            if (outdeg.get(ele) - indeg.get(ele) == 1) {
                start = ele;
                break;
            }
        }
        res = new LinkedList<>();
        dfs(start);
        int[] ele = res.stream().mapToInt(Integer::intValue).toArray();

        int[][] ans = new int[E][2];
        for (int i=1; i<=E; i++) {
            ans[i-1][0] = ele[i-1];
            ans[i-1][1] = ele[i];
        }
        return ans;
    }

    void dfs(int u) {
        while (outdeg.get(u) != 0) {
            int v = adj.get(u).get(outdeg.get(u) - 1);
            outdeg.put(u, outdeg.get(u) - 1);
            dfs(v);
        }
        res.offerFirst(u);
    }
}
