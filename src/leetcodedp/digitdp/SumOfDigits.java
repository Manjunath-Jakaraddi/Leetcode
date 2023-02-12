package leetcodedp.digitdp;

public class SumOfDigits {
    static int[][][] dp;
    public static void main(String[] args) {
        int L = 19, R = 50, S = 7;
        dp = new int[21][201][2];
        System.out.println(bruteForce(L, R, S));

        for (int x=0; x<21; x++) {
            for (int y=0; y<201; y++) {
                dp[x][y][0] = dp[x][y][1] = -1;
            }
        }
        int right = solve(0, S, true, String.valueOf(R), "");

        for (int x=0; x<21; x++) {
            for (int y=0; y<201; y++) {
                dp[x][y][0] = dp[x][y][1] = -1;
            }
        }
        int left = solve(0, S, true, String.valueOf(L-1), "");
        System.out.println(right - left);


        // Testing Solution vs Brute Force
//        for (int i=2; i<100; i++) {
//            for (int j=1; j<i; j++) {
//                for (int X=1; X<10; X++) {
//                    int bFAns = bruteForce(j, i, X);
//
//                    dp = new int[21][201][2];
//                    for (int x=0; x<21; x++) {
//                        for (int y=0; y<201; y++) {
//                            dp[x][y][0] = dp[x][y][1] = -1;
//                        }
//                    }
//                    int rightAns = solve(0, X, true, String.valueOf(i));
//
//                    dp = new int[21][201][2];
//                    for (int x=0; x<21; x++) {
//                        for (int y=0; y<201; y++) {
//                            dp[x][y][0] = dp[x][y][1] = -1;
//                        }
//                    }
//                    int leftAns = solve(0, X, true, String.valueOf(j-1));
//
//                    // The below line will not work as we need to compute left and right separately by clearing dp states
//                    // as those are two different problems
//                    // int dPAns = solve(0, X, true, String.valueOf(i)) - solve(0, X, true, String.valueOf(j-1));
//                    int dPAns = rightAns - leftAns;
//
//
//                    System.out.print(j + " " + i + " " + X + " :- ");
//                    if (bFAns != dPAns) {
//                        System.out.println("Fail!");
//                    } else {
//                        System.out.println("Pass!");
//                    }
//                }
//            }
//        }

    }

    static int solve(int pos, int sum, boolean tight, String num, String s) {
        if (sum < 0) {
            return 0;
        }
        if (pos == num.length()) {
            if (sum == 0) {
                System.out.println(s);
                return 1;
            }
            return 0;
        }
        int t = (tight ? 1 : 0);
        if (dp[pos][sum][t] != -1) {
            return dp[pos][sum][t];
        }
        int count = 0, lastAllowedDigit = (tight ? (num.charAt(pos) - '0') : 9);
        for (int i = 0; i <= lastAllowedDigit; i++) {
            count += solve(pos + 1, sum - i, tight && (i == lastAllowedDigit), num, s + i);
        }
        dp[pos][sum][t] = count;
        return dp[pos][sum][t];
    }

    static int bruteForce(int L, int R, int X) {
        int res = 0;
        for (int i=L; i<=R; i++) {
            if (check(i, X)) {
                res++;
            }
        }
        return res;
    }

    static boolean check(int i, int num) {
        int sum = 0;
        while (i > 0) {
            sum += (i % 10);
            i /= 10;
        }
        return sum == num;
    }
}

/**
 * Find the count of numbers between L and R which have sum of digits = X
 * 1 <= L <= R <= 10^18
 * 1 <= X <= 180
 */