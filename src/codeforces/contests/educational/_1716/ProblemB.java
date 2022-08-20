package codeforces.contests.educational._1716;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            res.append(N + "\n");
            for (int i=0; i<N; i++) {
                arr[i] = i+1;
            }
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    res.append(arr[j] + " ");
                }
                res.append("\n");
                int temp = arr[i];
                arr[i] = arr[N-1];
                arr[N-1] = temp;
            }
        }
        System.out.println(res);
    }
}
