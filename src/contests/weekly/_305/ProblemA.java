package contests.weekly._305;

import java.util.HashMap;
import java.util.Map;

public class ProblemA {
    public int arithmeticTriplets(int[] nums, int diff) {
        int N = nums.length;
        Map<Integer, Integer> mmap = new HashMap<>();
        mmap.put(nums[0], mmap.getOrDefault(nums[0], 0) + 1);
        int res = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[j] - nums[i] == diff) {
                    int findDiff = nums[i] - diff;
                    res += mmap.getOrDefault(findDiff, 0);
                }
            }
        }
        return res;
    }


    public int arithmeticTripletsOptimised(int[] nums, int diff) {
        boolean[] cnt = new boolean[201];
        int res = 0;
        for (int num : nums) {
            if (num >= 2 * diff) {
                if (cnt[num - diff] && cnt[num - 2 * diff]) {
                    res++;
                }
                cnt[num] = true;
            }
        }
        return res;
    }
}
