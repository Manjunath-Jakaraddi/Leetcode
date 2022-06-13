package leetcodedp;

public class DeleteAndEarn_4147 {
    public int deleteAndEarn(int[] nums) {
        int N = nums.length;
        int[] freq = new int[10004];
        int[] dp = new int[10004];
        for (int num : nums) {
            freq[num]++;
        }
        dp[1] = freq[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + (freq[i] * i));
        }
        return dp[10000];
    }
}
