package company.google.arraysandstring;

public class JumpGame_55 {
    public boolean canJumpOnSpace(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[N];
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            int jump = nums[i];
            if (!dp[i]) {
                return false;
            }
            if (i + jump >= N-1) {
                return true;
            }
            for (int j = 1; j <= jump; j++) {
                dp[i+j] = dp[i];
            }
        }
        return dp[N-1];
    }

    /**
     * In constant space
     */
    public boolean canJump(int[] nums) {
        int dis = 0;
        for (int i = 0; i <= dis; i++) {
            dis = Math.max(dis, i + nums[i]);
            if (dis >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
