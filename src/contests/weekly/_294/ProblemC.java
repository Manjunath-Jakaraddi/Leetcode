package contests.weekly._294;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProblemC {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        List<Double> slopes = new ArrayList<>();
        int N = stockPrices.length;
        for (int i = 0; i < N - 1; i++) {
            double y = (stockPrices[i+1][1] - stockPrices[i][1]);
            double x = (stockPrices[i+1][0] - stockPrices[i][0]);
            slopes.add(y/x);
        }
        int res = 1;
        for (int i = 0; i < slopes.size() - 1; i++) {
            if (Double.compare(slopes.get(i), slopes.get(i+1)) != 0) res++;
        }
        return res;
    }
}
