package contests.weekly._304;

import java.util.HashSet;
import java.util.Set;

public class ProblemA {
    public int minimumOperations(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums) {
            if (num > 0) {
                st.add(num);
            }
        }
        return st.size();
    }
}
