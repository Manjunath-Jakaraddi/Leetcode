package topinterview;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        rotateJump(nums ,4);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }

    public static void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        int temp = 0;
        for (int i=0; i < (end - start + 1)/2; i++) {
            temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    public static void rotateJump(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}

/**
 * 1. k can be greater than n so do k = k % n
 * ## Trick ->
 * reverse first part of array
 * and then second part of array
 * and then whole array
 *
 * Another Trick (Revise)
 * Cyclic Jumps until we end up on same start
 * but keep count of swaps as the breaking condition
 */