package algorithms.numtheory;

import java.util.Scanner;

public class A_BinaryExponentiation {
    private static final int MOD = 1_000_000_000 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt(), pow = sc.nextInt();
        long res = 1;
        while (pow > 0) {
            if (pow % 2 != 0) {
                // If the bit is turned on for particular computed power include it
                res = (res * num) % MOD;
            }

            // Computes the all powers (1, 2, 4, 8, 16)
            num = (num * num) % MOD;

            pow >>= 1;
        }

    }


    long binaryExpo(int num, int pow) {
        long res = 1;
        while (pow > 0) {
            if (pow % 2 != 0)  res = (res * num) % MOD;
            num = (num * num) % MOD;
            pow >>= 1;
        }
        return res;
    }
}
