package contests.weekly._305;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemC {
    public boolean validPartition(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        Set<Integer> st = new HashSet<>();
        int sum = 0;
        for(int i=2; i<=N; i++) {
            st.clear();
            sum = nums[i-1] + nums[i-2];
            st.add(nums[i-1]);
            st.add(nums[i-2]);
            if (st.size() == 1) {
                dp[i] |= dp[i-2];
            }
            if (i >= 3) {
                sum += nums[i-3];
                st.add(nums[i-3]);
                if (st.size() == 1) {
                    dp[i] |= dp[i-3];
                }
                if (st.size() == 3 && (nums[i-3] * 3 + 3 == sum)) {
                    dp[i] |= dp[i-3];
                }
            }
        }
        return dp[N];
    }
}
