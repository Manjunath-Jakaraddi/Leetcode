package topinterview.arrays;

import java.util.HashMap;
import java.util.Map;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/546/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            int findNum = target - nums[i];
            if (hmap.containsKey(findNum)) {
                return new int[] {hmap.get(findNum), i};
            }
            hmap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}

/**
 * Solving in one pass
 */