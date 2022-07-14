package contests.biweekly._81;

public class ProblemD {
    private int MOD = (int) 1e9+7;
    public int distinctSequences(int N) {
        if (N == 1) {
            return 6;
        }
        int[][] dp = new int[7][7];
        boolean[][] gcd = new boolean[7][7];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                gcd[i][j] = gcd(i, j) == 1;
                if (gcd[i][j]) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 3; i <= N; i++) {
            int[][] newdp = new int[7][7];
            for (int prev = 1; prev <= 6; prev++) {
                for (int curr = 1; curr <=6 ; curr++) {
                    for (int next = 1; next <= 6; next++) {
                        if (gcd[curr][next] && prev != next) {
                            newdp[curr][next] = (dp[prev][curr] + newdp[curr][next]) % MOD;
                        }
                    }
                }
            }
            dp = newdp;
        }
        long res = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                res = (res + dp[i][j]) % MOD;
            }
        }
        return (int) res;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
/**
 * Awesome job!!! Your first 3D dp solve
 * First pattern identification for the gcd worked fine
 *  but when struck with the requirement for prev of prev state
 *  your intuition to pick another state variable worked in favour
 */
/*
1 -> 2, 3, 4, 5, 6
2 -> 1, 3, 5,
3 -> 1, 2, 4, 5
4 -> 1, 3, 5
5 -> 1, 2, 3, 4, 6
6 -> 1, 5

1 -> 2, 3, 4, 5, 6 ->
2 -> 3, 5,         ->
3 -> 4, 5
4 -> 5
5 -> 6
6 ->
*/

// dp state -> i, prevNum, currentNum