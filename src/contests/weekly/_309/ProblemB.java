package contests.weekly._309;

public class ProblemB {
    int MOD = (int) 1e9+7;
    public int numberOfWays(int startPos, int endPos, int k) {
        int dist = endPos - startPos;
        int rem = k - dist;
        if(rem >= 0 && (k - dist) % 2 == 0) {
            int cnt = rem / 2;
            long res = 1, dRes = 1;
            while (cnt > 0) {
                res = (res * (long) k) % MOD;
                dRes = (dRes * (long) cnt) % MOD;
                cnt--;
                k--;
            }
            long fRes = (res * binPow(dRes, MOD-2)) % MOD;
            return (int) fRes;
        }
        return 0;
    }

    long binPow(long num, long pow) {
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
        return res;
    }
}
