package contests.weekly._298;

import java.util.Arrays;

public class ProblemB {
    public static void main(String[] args) {
        System.out.println(minimumNumbers2(0, 7));
    }

    static public int minimumNumbers1(int num, int k) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;
        while (k < num) {
            for (int i = 0; i <= num; i++) {
                if (i - k >= 0 && dp[i] > dp[i - k] + 1) {
                    dp[i] = dp[i - k] + 1;
                }
            }
            k += 10;
        }
        return dp[num] == 987654321 ? -1 : dp[num];
    }

    static public int minimumNumbers2(int num, int k) {
        if (num == 0) return 0;
        for (int i = 1; i * k <= num && i <= 10; i++) {
            if (i * k % 10 == num % 10) return i;
        }
        return -1;
    }

}
/**
 * Second more optimized try to get only the units place matched with i numbers
 * all the other places can be adjusted accordingly to get the total number
 */
// 3000
// 9 9 9 9 9 9 9 9 2909 9