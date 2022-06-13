package contests.weekly._293;

import java.util.Arrays;

public class ProblemB {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int N = special.length;
        Arrays.sort(special);
        int res = Math.max(special[0] - bottom, top - special[N - 1]);
        for (int i = 1; i < N; i++) {
            res = Math.max(res, special[i] - special[i-1] - 1);
        }
        return res;
    }
}
