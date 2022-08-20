package company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int N = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        res.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i=1; i<N; i++) {
            if (res.get(res.size()-1)[1] >= intervals[i][0])
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], intervals[i][1]);
            else
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
