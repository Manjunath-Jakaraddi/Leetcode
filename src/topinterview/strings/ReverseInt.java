package topinterview.strings;

import java.util.Scanner;

// Link:= https://leetcode.com/problems/reverse-integer/
public class ReverseInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public int reverse(int x) {
        long res = 0;
        boolean isNeg = false;
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        while(x != 0) {
            res*=10;
            res += (x%10);
            if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
                return 0;
            }
            x/=10;
        }
        return (int)res;
    }

    public int reverseWithoutLong(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

/**
 * Trick:
 * Do it without using Long
 */