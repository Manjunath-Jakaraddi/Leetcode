package contests.biweekly._84;

import java.util.HashMap;
import java.util.Map;

public class ProblemB {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> mmap = new HashMap<>();
        long N = nums.length;
        for (int i = 0; i < N; i++) {
            int diff = i - nums[i];
            mmap.put(diff, mmap.getOrDefault(diff, 0L) + 1L);
        }
        long goodPairs = 0;
        for (long val : mmap.values()) {
            goodPairs += ((val * (val - 1)) >> 1);
        }
        long res = ((N * (N - 1)) >> 1);
        return res - goodPairs;
    }

    public long countBadPairsTrick(int[] nums) {
        Map<Integer, Long> mmap = new HashMap<>();
        int N = nums.length;
        long res = 0;
        for (int i = 0; i < N; i++) {
            res += (long) i - mmap.getOrDefault(nums[i] - i, 0L);
            mmap.put(nums[i] - i, mmap.getOrDefault(nums[i] - i, 0L) + 1);
        }
        return res;
    }
}

/**
 * Good solve **
 * Can also use the combinatorics with map trick to count as you build the map
 */
