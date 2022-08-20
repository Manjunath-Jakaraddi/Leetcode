package contests.biweekly._84;


public class ProblemD {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int N = nums.length;
        long prevNum = nums[N-1], k, res = 0, currNum;
        for (int i = N-2; i >= 0; i--) {
            currNum = nums[i];
            k = (long) Math.ceil(prevNum/currNum);
            res += k-1;
            prevNum = currNum / k;
        }
        return res;
    }
}

/**
 * Reverse array in Java TODO: Collections.reverse(Arrays.asList(nums))
 * TODO: Google hard interview question
 * https://leetcode.com/problems/minimum-replacements-to-sort-the-array/discuss/2388143/Python-Google-interview-problem-why-strategy-beats-implementation
 * Explanation above
 * Important thing to remember: or any positive integer n and all 1 <= k <= n,
 * it's possible to represent n as the sum of k numbers, such that all numbers differ by no more than 1.
 */
