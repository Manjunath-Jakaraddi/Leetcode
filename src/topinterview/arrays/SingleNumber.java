package topinterview.arrays;

// Link:- https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res = (res ^ num);
        }
        return res;
    }
}

/**
 * Trick:
 *  Xor operation -> a ^ b ^ a = b
 *  Add all nums to set
 *  2 * sumOfSet - sumOfNums = ans
 */