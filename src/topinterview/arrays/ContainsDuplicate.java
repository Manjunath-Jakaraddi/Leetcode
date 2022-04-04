package topinterview.arrays;

import java.util.HashMap;
import java.util.Map;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> hmap = new HashMap<>();
        for(int num : nums) {
            if(hmap.containsKey(num)) {
                return true;
            }
            hmap.put(num, true);
        }
        return false;
    }
}
