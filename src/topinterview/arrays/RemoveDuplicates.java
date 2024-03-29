package topinterview.arrays;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i=0;
        for (int j=1; j< nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}

/**
 * Two pointer simple approach
 */