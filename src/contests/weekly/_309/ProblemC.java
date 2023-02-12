package contests.weekly._309;

public class ProblemC {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, r = 0;
        int curr = 0;
        int res = 0;
        while (r < nums.length) {
            if ((curr & nums[r]) == 0) {
                curr |= nums[r];
                r++;
            } else {
                curr ^= nums[l];
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
