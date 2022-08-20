package contests.weekly._303;

import java.util.Arrays;

public class ProblemD {
    public long countExcellentPairs(int[] nums, int k) {
        int N = nums.length;
        long res = 0, cnt[] = new long[30];
        for (int num : Arrays.stream(nums).distinct().toArray()) {
            cnt[Integer.bitCount(num)]++;
        }

        for (int i = 1; i < 30; i++) {
            for (int j = Math.max(i, k - i); j < 30; j++) {
                res += (cnt[i] * cnt[j] * ( i == j ? 1 : 2));
            }
        }
        return res;
    }
}
