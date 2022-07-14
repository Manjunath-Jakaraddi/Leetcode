package codeforces.contests.div4._1692;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
            int res = check(b > a) + check(c > a) + check(d > a);
            System.out.println(res);
        }
    }

    private static int check(boolean ch) {
        return ch ? 1 : 0;
    }
}
