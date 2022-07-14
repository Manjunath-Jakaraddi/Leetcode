package contests.weekly._299;

public class ProblemB {
    static int MOD = (int) 1e9+7;
    public static void main(String[] args) {
        System.out.println(countHousePlacements(10));
    }
    public static int countHousePlacements1(int N) {
        int[][] dp = new int[N+1][4];
        dp[1] = new int[]{1, 1, 1, 1};
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][3] + dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][2] + dp[i-1][0]) % MOD;
            dp[i][2] = (dp[i-1][1] + dp[i-1][0]) % MOD;
            dp[i][3] = dp[i-1][0];
        }
        return (dp[N][0] + dp[N][1] + dp[N][2] + dp[N][3]) % MOD;
    }

    public static int countHousePlacements(int N) {
        int placed = 0, empty = 1, res = 1;
        for (int i = 1; i <= N; i++) {
            placed = empty;
            empty = res;
            res = (placed + empty) % MOD;
        }
        return (int) (((long) res * res) % MOD);
    }


}

/**
 * Your solution it fine but placing of houses on one side does not affect another (combinatorics)
 * so this is the house robbing dp (fibonacci) to get the answer we will have to square
 * the one sides answer
 */