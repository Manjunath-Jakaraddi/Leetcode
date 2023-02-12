package contests.weekly._309;

import java.util.Arrays;

public class ProblemA {
    public boolean checkDistances(String s, int[] distance) {
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (prev[ch] != -1 && i - prev[ch] - 1 != distance[(ch - 'a')]) {
                return false;
            }
            prev[ch] = i;
        }
        return true;
    }
}
