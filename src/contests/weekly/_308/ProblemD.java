package contests.weekly._308;

import java.util.*;

public class ProblemD {
    Map<Integer, Set<Integer>> map;
    int[] indeg;
    int k;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.k = k;
        int[] rowTs = top_sort_func(rowConditions);
        int[] colTs = top_sort_func(colConditions);

        if (rowTs.length != k || colTs.length != k) {
            return new int[][] {};
        }

        int[] invRow = new int[k];
        int[] invCol = new int[k];
        for (int i = 0; i<k; i++) {
            invRow[rowTs[i]] = i;
            invCol[colTs[i]] = i;
        }
        int[][] res = new int[k][k];
        for (int i=0; i<k; i++) {
            res[invRow[i]][invCol[i]] = i+1;
        }
        return res;
    }


    int[] top_sort_func(int[][] conditions) {
        createGraph(conditions);
        List<Integer> top_sort = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<k; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : map.getOrDefault(curr, new HashSet<>())) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.offer(next);
                }
            }
            top_sort.add(curr);
        }
        return top_sort.stream().mapToInt(Integer::intValue).toArray();
    }


    void createGraph(int[][] conditions) {
        map = new HashMap<>();
        indeg = new int[k];
        for (int[] c : conditions) {
            c[0]--;
            c[1]--;
            map.putIfAbsent(c[0], new HashSet<>());
            if (map.get(c[0]).add(c[1])) {
                indeg[c[1]]++;
            }
        }
    }
}
