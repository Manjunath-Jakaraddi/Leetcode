package contests.biweekly._86;

import java.util.HashMap;
import java.util.Map;

public class ProblemA {
    public boolean findSubarrays(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i=1; i<nums.length; i++) {
            int sum = nums[i-1] + nums[i];
            if (map.containsKey(sum)) {
                return true;
            }
            map.putIfAbsent(sum, true);
        }
        return false;
    }
}
