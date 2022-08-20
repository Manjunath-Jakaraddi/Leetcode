package codeforces.contests.educational._1716;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int res = n / 3;
            if (n == 1) {
                System.out.println(2);
                continue;
            }
            if (n % 3 != 0) {
                res++;
            }
            System.out.println(res);
        }
    }
}