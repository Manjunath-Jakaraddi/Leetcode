package leetcodedp;

import java.util.Arrays;

public class MinimumJobSchedule_1335 {
    int[] postMax, jobDifficulty;
    int INF = 987654321;
    int N;
    int[][] mmap;
    public int minDifficulty(int[] jobDifficulty, int days) {
        N = jobDifficulty.length;
        this.jobDifficulty = jobDifficulty;
        mmap = new int[N+1][days+1];
        postMax = new int[N];
        postMax[N-1] = jobDifficulty[N-1];
        if (days > N) {
            return -1;
        }
        for (int i = 0; i <= N; i++) {
            Arrays.fill(mmap[i], -1);
        }
        for (int i = N-2; i >= 0; i--) {
            postMax[i] = Math.max(jobDifficulty[i], postMax[i+1]);
        }
        return solve(0, days);
    }

    public int minDifficulty2(int[] jobDifficulty, int days) {
        int N = jobDifficulty.length;
        int[][] dp = new int[days+1][N+1];
        int currMax = 0;
        for (int i = 0; i < N; i++) {
            currMax = Math.max(currMax, jobDifficulty[i]);
            dp[1][i+1] = currMax;
        }
        for (int day = 2; day < days; day++) {
            for (int i = 0; i < N - day + 1; i++) {
                dp[day][i] = Math.max()
            }
        }
    }

    int solve(int curr, int day) {
        if (day == 1) {
            return postMax[curr];
        }
        if (mmap[curr][day] != -1) {
            return mmap[curr][day];
        }
        int currMax = 0;
        int currAns = INF;
        for (int j = curr; j < N - day + 1; j++) {
            currMax = Math.max(currMax, jobDifficulty[j]);
            currAns = Math.min(currAns, currMax + solve(j+1, day-1));
        }

        mmap[curr][day] = currAns;
        return currAns;
    }
}
