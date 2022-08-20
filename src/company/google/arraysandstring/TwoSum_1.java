package company.google.arraysandstring;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mmap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (mmap.containsKey(target - nums[i])) {
                return new int[] {mmap.get(target - nums[i]), i};
            }
            mmap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
