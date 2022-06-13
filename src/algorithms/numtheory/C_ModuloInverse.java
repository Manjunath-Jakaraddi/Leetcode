package algorithms.numtheory;

public class C_ModuloInverse {
    // Using Extended Euclidean
    // if A and M are co-prime there should exist a inverse modulo for A
    // such that (A * A-inverse) % M = 1
    // we have as per Extended Euclidean Ax + My = 1 (gcd 1 as A and M are co-prime)
    // hence x is the inverse of A because (A*InvA + M * y) % M = 1 => (A*InvA)%M = 1
    // More info:- https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/
    private static int d, x, y;

    public static void main(String[] args) {
        int A = 5, M = 12;
        // Inverse using Extended Euclid
        extendedEuclid(A, M);
        x = (x % M + M) % M; // x can be negative or greater than M
        // System.out.printf("Inverse of %d modulo %d is %d", A, M, x);


        // Inverse using Fermat's little theorem (binary exponentiation)
        // Only applicable when M is prime (not co-prime)
        // A^(M-1) % M = 1 => multiplying inverse on both sides
        // A^(M-2) % M = A-Inverse
        System.out.printf("Inverse of %d modulo %d is %d", A, 13, binaryExpo(A, 13-2));
    }

    public static void extendedEuclid(int A, int B) {
        if (B == 0) {
            d = A;
            x = 1;
            y = 0;
            return;
        }
        extendedEuclid(B, A%B);
        int temp = x;
        x = y;
        y = temp - (A/B) * y;
    }

    private static final int MOD = 13;
    private static int binaryExpo(int num, int pow) {
        long res = 1;
        while (pow > 0) {
            if (pow % 2 != 0)  res = (res * num) % MOD;
            num = (num * num) % MOD;
            pow >>= 1;
        }
        return (int) res;
    }
}
