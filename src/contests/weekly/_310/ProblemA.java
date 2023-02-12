package contests.weekly._310;

import java.util.Map;
import java.util.TreeMap;

public class ProblemA {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> freq = new TreeMap<>();
        int ans = -1, maxFreq = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                continue;
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
