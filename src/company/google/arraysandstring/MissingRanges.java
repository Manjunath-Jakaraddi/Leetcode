package company.google.arraysandstring;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int N = nums.length;
        List<String> res = new ArrayList<>();
        lower--;
        upper++;
        if (N == 0) {
            checkAndAdd(lower, upper, res);
            return res;
        }
        checkAndAdd(lower, nums[0], res);
        for(int i=1; i<N; i++) {
            checkAndAdd(nums[i-1], nums[i], res);
        }
        checkAndAdd(nums[N-1], upper, res);
        return res;
    }

    void checkAndAdd(int left, int right, List<String> resList) {
        if (right - left > 1) {
            if (right - left == 2) {
                resList.add(((left + 1) + ""));
            } else {
                resList.add((left + 1) + "->" + (right - 1));
            }
        }
    }
}
