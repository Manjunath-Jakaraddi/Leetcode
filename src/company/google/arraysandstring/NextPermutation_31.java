package company.google.arraysandstring;

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int ind = -1;
        for (int i = N-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            // reverse instead of sort for in place no extra memory
            Arrays.sort(nums);
        } else {
            int mnInd = N-1;
            while(nums[ind] >= nums[mnInd]) {
                mnInd--;
            }

            int temp = nums[mnInd];
            nums[mnInd] = nums[ind];
            nums[ind] = temp;
            // reverse instead of sort for in place no extra memory
            Arrays.sort(nums, ind+1, N);

        }
    }
}

/**
 * Strategy is simple:
 * start from last and work backwards find the first element that is non decreasing
 * so that index is where the next permutation starts from
 * to find the number of next permutation it should be swapped with the next big number
 * in the elements to the right (which are decreasingly sorted as we have found the first non decresing one)
 * so traverse backwards and find the just greater element swap it
 * last step would be to sort all the elements to the right of the swapped elements
 * as that leads to the first permutation
 *
 * Also another important point to remember is instead of sorting we can just revere from the index found
 * as the right part of the array is already in decreasing order
 */
