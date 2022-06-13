package algorithms.numtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_PrimesAndFactors {

    // Check up until sqrt and
    // handle sqrt as a special case
    // (not required to check if prime or not but for factors count calculation)
    // Complexity:= Sqrt(N)
    private static void factorsCount(int N) {
        int countFactors = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i * i == N) countFactors++;
                else countFactors+=2;
            }
        }
        if (countFactors == 2) {
            System.out.printf("%d : Is Prime\n", N);
        } else {
            System.out.printf("%d : Is not Prime\n", N);
        }
    }

    // Second loop start with i*i because
    // in the first loop all the multiple previous of i (like 1, 2, ... upto i are already completed)
    // Complexity: N * (½ + ⅓ + ⅕ + … ) = O(N loglogN)
    private static void seiveOfErathosthenes(int N) {
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }
        primes.forEach(p -> System.out.print(p + " "));
    }

    // Here we always want to use the least multiple to divide by N in every step
    // that is we can eliminate the first loop by storing this during seive
    // Complexity: Sqrt(N)
    private static void factorize(int N) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i*i <= N; i++) {
            while (N % i == 0) {
                res.add(i);
                N /= i;
            }
        }
        if (N != 1) {
            res.add(N);
        }
        res.forEach(f -> System.out.print(f + " "));
        System.out.println();
    }

    // Optimized factoring
    private static void optimizedFactoring(int N) {
        int[] minPrime = new int[N+1];
        Arrays.fill(minPrime, 0);
        for (int i = 2; i * i <= N; i++) {
            if (minPrime[i] == 0) {
                for (int j = i*i; j <= N; j+=i) {
                    if (minPrime[j] == 0) {
                        // To check if not been updated by a smaller number already
                        minPrime[j] = i;
                    }
                }
            }
        }

        // For prime numbers set minPrime to be the same number
        for (int i = 2; i <= N; i++) {
            if (minPrime[i] == 0) minPrime[i] = i;
        }

        List<Integer> factors = new ArrayList<>();
        while (N != 1) {
            factors.add(minPrime[N]);
            N /= minPrime[N];
        }
        factors.forEach(f -> System.out.print(f + " "));
        System.out.println();
    }

    private static boolean checkPrime(int N) {
        for (int i = 2; i*i <= N ; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        seiveOfErathosthenes(100);
        System.out.println();
        factorsCount(100);
        factorsCount(97);
        optimizedFactoring(100);
        System.out.println(checkPrime(97));
    }

    // Next : Primality test and Euler's Totient Function

}
