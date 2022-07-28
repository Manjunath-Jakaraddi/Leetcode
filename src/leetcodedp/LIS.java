package leetcodedp;

import java.util.ArrayList;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }

    private int binarySearch(ArrayList<Integer> sub, int num) {
        int l = 0, r = sub.size();
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * TODO: O(nlogn)
 * Revise building the most optimal subsequence by always choosing the lower element
 * as it opens more possibilities (by greedy approach)
 */
