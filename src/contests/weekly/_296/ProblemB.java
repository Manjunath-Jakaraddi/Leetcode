package contests.weekly._296;

import java.util.Arrays;

public class ProblemB {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums.length;
        int currInd = 0, ind = 0, res = 1;
        while (ind < N) {
            if (nums[ind] - nums[currInd] <= k) {
                ind++;
            } else {
                res++;
                currInd = ind;
                ind++;
            }
        }
        return res;
    }
}