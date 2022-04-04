package topinterview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/559/
public class PlusOne {
    public static void main(String[] args) {
        int[] digs = new int[] {1, 2, 3};
        plusOneOptimised(digs);
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> digs = Arrays.stream(digits).boxed().collect(Collectors.toList());
        Collections.reverse(digs);
        int carry = 1;
        for (int i = 0; i < digs.size(); i++) {
            int num = digs.get(i);
            digs.set(i, (num + carry) % 10);
            carry = (num + carry) / 10;
        }
        if (carry != 0) {
            digs.add(carry);
        }
        Collections.reverse(digs);
        return digs.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] plusOneOptimised(int[] digits) {
        int n = digits.length;
        for (int i= n-1; i >= 0; i++) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}

/**
 * Trick:
 * Just add to the end number if not nine
 * else go on till nine make them zero and add one to the first non-nine
 * else if all nine create new array (which will be all zeros) and make the first number one
 */