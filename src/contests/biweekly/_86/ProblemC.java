package contests.biweekly._86;

import java.util.HashMap;
import java.util.Map;

public class ProblemC {
    public int maximumRows(int[][] mat, int cols) {
        int N = mat.length, M = mat[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        int eRes = 0;
        for (int i=0; i<N; i++) {
            int mask = 0;
            for (int j=0; j<M; j++) {
                mask|= (mat[i][j] << j);
            }
            if (mask == 0) {
                eRes++;
            } else {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }
        int ans = 0;
        for (int i=1; i<((1<<13)-1); i++) {
            int res = 0;
            if (Integer.bitCount(i) == cols) {
                for (int mask=i; mask>0; mask=((mask - 1) & i)) {
                    res += map.getOrDefault(mask, 0);
                }
            }
            ans = Math.max(res, ans);

        }
        return ans + eRes;
    }
}

/**
 * Brute force it with backtracking, but I chose some sub masks of a mask approach
 * Different and good approach but costed contest points :(
 */