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

    public int minDifficultyMine(int[] jobDifficulty, int totalDays) {
        int N = jobDifficulty.length;
        int[][] dp = new int[N][totalDays+1];
        int currMax = 0, currAns = 0;
        if (totalDays > N) {
            return -1;
        }
        for (int i = N-1; i >= 0; i--) {
            currMax = Math.max(currMax, jobDifficulty[i]);
            dp[i][1] = currMax;
        }
        for (int day = 2; day <= totalDays; day++) {
            for (int i = totalDays - day; i < N - day + 1; i++) {
                int hardest = 0;
                dp[i][day] = Integer.MAX_VALUE;
                for (int j = i; j < N - day + 1; j++) {
                    hardest = Math.max(hardest, jobDifficulty[j]);
                    dp[i][day] = Math.min(dp[i][day], hardest + dp[j+1][day-1]);
                }
            }
        }

        return dp[0][totalDays];
    }

    public int minDifficultyLeetcode(int[] jobDifficulty, int totalDays) {
        int N = jobDifficulty.length;
        int[][] dp = new int[N][totalDays+1];
        int currMax = 0, currAns = 0;
        if (totalDays > N) {
            return -1;
        }
        for (int i = N-1; i >= 0; i--) {
            currMax = Math.max(currMax, jobDifficulty[i]);
            dp[i][totalDays] = currMax;
        }
        for (int day = totalDays - 1; day > 0; day++) {
            for (int i = day - 1; i < N - (totalDays - day); i++) {
                int hardest = 0;
                for (int j = i; j < N - (totalDays - day); j++) {
                    hardest = Math.max(hardest, jobDifficulty[j]);
                    dp[i][day] = Math.min(dp[i][day], hardest + dp[j+1][day+1]);
                }
            }
        }

        return dp[0][1];
    }
}
