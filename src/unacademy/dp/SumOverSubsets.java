package unacademy.dp;

import java.util.Scanner;

public class SumOverSubsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
//          new Solver().solve1(N, arr);
//          new Solver().solve2(N, arr);
            new Solver().solve3(N, arr);
        }
    }
}

class Solver {
    // Complexity 2^N * 2^N = 4^N
    // Here we are iterating over all subset for a given subset
    // so optimize to visit on the required subsets using formula
    public void solve1(int N, int[] f) {
        int[] h = new int[N];

        for (int t = 0; t < N; t++) {
            System.out.print(t + " : ");
            for (int x = 0; x < N; x++) {
                if ((t&x) == x) {
                    h[t] += f[x];
                    System.out.print(x + " ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(h[i] + " ");
        }
        System.out.println();
    }

    // Here we are visiting only the subsets of the given subset
    // It can be proven using amortized method time complexity is 3^N which is still large
    public void solve2(int N, int[] f) {
        int[] h = new int[N];

        for (int t = 0; t < N; t++) {
            System.out.print(t + " : ");
            for (int x = t; x > 0; x=((x-1)&t)) {
                if ((t&x) == x) {
                    h[t] += f[x];
                    System.out.print(x + " ");
                }
            }
            h[t] += f[0];
            System.out.println("0");
        }

        for (int i = 0; i < N; i++) {
            System.out.print(h[i] + " ");
        }
        System.out.println();
    }


    // Can be further optimized using dp
    // dp(i, j) -> for ith numbered mask chosen subset
    // the sum over all subsets produced by allowing the j LSB to change
    public void solve3(int N, int[] f) {
        int[][] dp = new int[N][21];

        for (int t = 0; t < N; t++) {
            dp[t][0] = f[t];
        }
        int z = log2nlz(N)+1;
        for (int t = 0; t < N; t++) {
            for (int x = 1; x <= z; x++) {
                if ((t & (1<<(x-1))) != 0) {
                    dp[t][x] = dp[t][x-1] + dp[(t^(1<<(x-1)))][x-1];
                } else {
                    dp[t][x] = dp[t][x-1];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(dp[i][z-1] + " ");
        }
        System.out.println();
    }

    public static int log2nlz( int bits )
    {
        if( bits == 0 )
            return 0; // or throw exception
        return 31 - Integer.numberOfLeadingZeros( bits );
    }
}