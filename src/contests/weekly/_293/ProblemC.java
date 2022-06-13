package contests.weekly._293;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProblemC {
    public int largestCombination(int[] candidates) {
        int mx_ele = 0;
        int N = candidates.length;
        int ind = -1;
        int[] freq = new int[26];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 26; j++) {
                if ((candidates[i] & (1 << j)) != 0) {
                    freq[j]++;
                    if (freq[j] > mx_ele) {
                        mx_ele = freq[j];
                        ind = j;
                    }
                }
            }
        }
        return mx_ele;
    }
}
