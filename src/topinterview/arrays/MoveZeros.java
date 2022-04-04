package topinterview.arrays;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/567/
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[ind++] = nums[i];
            }
        }
        while(ind < nums.length) {
            nums[ind++] = 0;
        }
    }

    public void moveZeroesOptimized(int[] nums) {
        int ind = 0;
        int temp = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                ind++;
            }
        }
    }
}

/**
 * Trick:
 * When all zeros but last one the first one might not be optimized
 * as we need to assign all zeros till end
 * So inorder to optimize just swap the numbers
 * (need to swap and not directly assign zero to other)
 * (as the ind and the number i might be same)
 */