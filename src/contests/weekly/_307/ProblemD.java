package contests.weekly._307;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProblemD {
    public long kSum(int[] nums, int k) {
        long sum = 0;
        int N = nums.length;
        for (int i=0; i<N; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }
        if (k == 1) {
            return sum;
        }
        Arrays.sort(nums);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
        pq.offer(new long[] {nums[0], 0});
        long[] curr = new long[] {-1, -1};
        while (k - 1 > 0) {
            curr = pq.poll();
            long cSum = curr[0];
            int cIdx = (int) curr[1];
            if (cIdx < N-1) {
                // Cannot include exclude the element at index i
                // as that will generate many sums that are equal to the greatest value
                // (i.e always exclusions case)
                pq.offer(new long[] {cSum + nums[cIdx + 1], (long) cIdx + 1});
                pq.offer(new long[] {cSum + nums[cIdx + 1] - nums[cIdx] , (long) cIdx + 1});
            }
            k--;
        }
        return sum - curr[0];
    }
}
/**
 * TODO: Revise new concept of generating increasing sums using priority queue
 * by using the inclusion exclusion principle. Because we need not generate all the
 * subsequences or all permutations as the Kth largest sum we want to find might not need
 * all permutations as K is small and when generated in increasing order we can terminate earlier
 *
 * Inclusion Exclusion Principle
 * 1. Sort the array first so we always start the sum from smallest number
 * 2. Add the currSums to priority queue so that we can always pick the smallest number to
 *      generate the next number
 * 3. And last generate the next sum in order (transition using Inclusion Exclusion principle)
 * i.e -> 1) currSum + nextElement
 *        2) currSum + nextElement - prevElement
 *
 * Another similar problem (not same solution):- https://leetcode.com/problems/kth-smallest-subarray-sum/
 */
