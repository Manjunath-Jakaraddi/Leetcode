package contests.weekly._303;

import java.util.HashMap;
import java.util.Map;

public class ProblemB {
    public int equalPairs(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        HashMap<String, Integer> hmapr = new HashMap<>(), hmapc = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sbr = new StringBuilder();
            StringBuilder sbc = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sbr.append(grid[i][j]).append(",");
                sbc.append(grid[j][i]).append(",");
            }
            hmapr.put(sbr.toString(), hmapr.getOrDefault(sbr.toString(), 0) + 1);
            hmapc.put(sbc.toString(), hmapc.getOrDefault(sbc.toString(), 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : hmapr.entrySet()) {
            if (hmapc.containsKey(entry.getKey())) {
                res += (entry.getValue() * hmapc.get(entry.getKey()));
            }
        }
        return res;
    }

    public int equalPairsCounting(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int res = 0;
        HashMap<String, Integer> hmap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(grid[i][j] + ",");
            }
            hmap.put(sb.toString(), hmap.getOrDefault(sb.toString(), 0) + 1);
        }
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(grid[j][i] + ",");
            }
            res += hmap.getOrDefault(sb.toString(), 0);
        }
        return res;
    }
}
/**
 * Think:- Can also be solved with Trie
 */