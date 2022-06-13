package contests.weekly._294;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemB {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Integer> lst = new ArrayList<>();
        int N = rocks.length;
        for (int i = 0; i < N; i++) {
            lst.add(capacity[i] - rocks[i]);
        }
        Collections.sort(lst);
        int ind = 0;
        while (ind < lst.size() && additionalRocks >= lst.get(ind) ) {
            additionalRocks -= lst.get(ind);
            ind++;
        }
        return ind;
    }
}
