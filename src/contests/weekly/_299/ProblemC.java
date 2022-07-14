package contests.weekly._299;

public class ProblemC {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int[] diff = new int[N];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            diff[i] = nums2[i] - nums1[i];
        }
        int maxSoFar = diff[0], minSoFar = diff[0];
        int maxSum = diff[0], minSum = diff[0];
        for (int i = 1; i < N; i++) {
            maxSoFar = Math.max(maxSoFar + diff[i], diff[i]);
            maxSum = Math.max(maxSum, maxSoFar);
            minSoFar = Math.min(minSoFar + diff[i], diff[i]);
            minSum = Math.min(minSoFar, minSum);
        }
        return Math.max(sum1 + maxSum, sum2 - minSum);
    }
}

/**
 * Good job, your intuition to use kadane's algorithm worked correctly
 *  then differencing the max and minimum will give the answer
 */