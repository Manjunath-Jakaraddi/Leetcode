package contests.weekly._308;

import java.util.Arrays;

public class ProblemA {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int[] res = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            res[i] = Arrays.binarySearch(nums, queries[i]);
            if (res[i] < 0) {
                res[i] = -res[i] - 1;
            }
            else {
                res[i]++;
            }
        }
        return res;
    }
}
