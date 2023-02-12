package algorithms;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int M = sc.nextInt();
        }
    }


    public static int main(String S) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        int N = arr.length();
        int end = arr.charAt(N-1);
        int seq = 0, ans = 0;
        for (int i=0; i<N-1; i++) {
            int curr = arr.charAt(i) - 'a';
            if (curr == seq)  continue;
            ans++;
            curr = (curr + 1) % 3;
            seq = (seq + 1) % 3;
            if (curr == seq) continue;
            ans++;
            curr = (curr + 1) % 3;
            seq = (seq + 1) % 3;
        }
        System.out.println(ans);
        return 0;
    }

    public static int solution(String S) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        int N = arr.length();
        int end = arr.charAt(N-1);
        int seq = 0, ans = 0;
        for (int i=0; i<N-1; i++) {
            int curr = arr.charAt(i) - 'a';
            if (curr == seq)  continue;
            ans++;
            curr = (curr + 1) % 3;
            seq = (seq + 1) % 3;
            if (curr == seq) continue;
            ans++;
            curr = (curr + 1) % 3;
            seq = (seq + 1) % 3;
        }
        System.out.println(ans);
        return 0;
    }
}
