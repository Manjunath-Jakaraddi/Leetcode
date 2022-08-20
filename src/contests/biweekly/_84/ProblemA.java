package contests.biweekly._84;

import java.util.*;

public class ProblemA {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> mmap = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int[] item : items1) {
            mmap.put(item[0], item[1]);
        }
        for(int[] item : items2) {
            mmap.put(item[0], mmap.getOrDefault(item[0], 0) + item[1]);
        }
        for (Map.Entry<Integer, Integer> entry : mmap.entrySet()) {
            res.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        return res;
    }
}
