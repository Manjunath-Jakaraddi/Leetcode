package algorithms.numtheory;

public class B_GCDAndExtendedEuclidean {
    private static int d, x, y;

    public static void main(String[] args) {
        System.out.println(gcd(15, 25));
        extendedEuclid(15, 25);
        System.out.printf("15*(%d) + 25*(%d) = %d", x, y, d);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Extended Euclid Ax + By = GCD(A, B) (25 * 2 - 15 * 3 = 5)
    // find co-eff x, y and d = gcd
    // Compute GCD normal and while coming back compute the coefficient at every step and backtrack using formula
    // See formula proof https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/
    // x = y1
    // y = x1 - floor(A/B) * y1
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
}
