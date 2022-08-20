package leetcodedp;

import java.util.ArrayList;
import java.util.List;

public class HatsWays_1434 {
    private int MOD = (int) 1e9 + 7;
    public int numberWays(List<List<Integer>> hats) {
        int P = hats.size();
        ArrayList<Integer>[] persons = new ArrayList[41];
        for (int i = 0; i < 41; i++) {
            persons[i] = new ArrayList<>();
        }
        for (int person = 0; person < P; person++) {
            for (int hat : hats.get(person)) {
                persons[hat].add(person);
            }
        }
        int[][] dp = new int[41][1<<P];
        dp[0][0] = 1;
        for (int hat = 1; hat < 41; hat++) {
            for (int mask = 0; mask < (1 << P); mask++) {
                dp[hat][mask] = dp[hat-1][mask];
                // skipping this hat picking and continuing the previous answer
                for (int person : persons[hat]) {
                    if ((mask & (1 << person)) != 0) {
                        // if the hat is picked in this step for person then adding the previous ans of not picking hats for that person
                        dp[hat][mask] += dp[hat-1][(mask ^ (1 << person))];
                        dp[hat][mask] %= MOD;
                    }
                }
            }
        }
        // returning the answer for the last hat and all hats picked up
        return dp[40][(1<<P)-1];
    }
}
