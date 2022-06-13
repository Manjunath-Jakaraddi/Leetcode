package leetcodedp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultiplicationOperations_1770 {


}

class BottomUp {
    public int maximumScore(int[] nums, int[] multipliers) {
        int N = nums.length, M = multipliers.length;
        int[][] dp = new int[M+1][M+1];
        for (int i = M-1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int mult = multipliers[i];
                int left = j;
                int right = N - 1 - (i - j);
                dp[i][j] = Math.max(
                        (nums[left] * mult) + dp[i+1][j+1],
                        (nums[right] * mult) + dp[i+1][j]
                );
            }
        }
        return dp[0][0];
    }

}

class TopDown {
    int[][] mmap;
    int N, M;
    public int maximumScore(int[] nums, int[] multipliers) {
        N = nums.length; M = multipliers.length;
        mmap = new int[M][N];
        for(int i=0; i<M; i++) {
            Arrays.fill(mmap[i], -1);
        }

        return solve(0, 0, nums, multipliers);
    }

    int solve(int curr, int took, int[] nums, int[] multipliers) {
        if (curr == M) return 0;
        int left = took;
        int right = N - 1 - (curr - took);
        if (mmap[curr][took] != -1) {
            return mmap[curr][took];
        }
        int takeLeft = multipliers[curr] * nums[left];
        int takeRight = multipliers[curr] * nums[right];
        mmap[curr][took] = Math.max(takeLeft + solve(curr+1, took+1, nums, multipliers), takeRight + solve(curr+1, took, nums, multipliers));
        return mmap[curr][took];
    }
}