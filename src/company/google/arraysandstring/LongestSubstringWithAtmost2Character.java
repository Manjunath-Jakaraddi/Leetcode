package company.google.arraysandstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmost2Character {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int N = s.length();
        char[] fruits = s.toCharArray();

        Map<Integer, Integer> mmap = new HashMap<>();
        int i = 0, j, res = 0;
        for (j = 0; j < N; j++) {
            mmap.put((int) fruits[j], mmap.getOrDefault(fruits[j], 0) + 1);
            while (mmap.size() > 2) {
                mmap.put((int) fruits[i], mmap.get(fruits[i]) - 1);
                mmap.remove(fruits[i++], 0);
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }


    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int N = s.length();
        int[] fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = s.charAt(i);
        }

        Map<Integer, Integer> mmap = new HashMap<>();
        int i = 0, j = 0, res = 0;
        for (j = 0; j < N; j++) {
            mmap.put(fruits[j], mmap.getOrDefault(fruits[j], 0) + 1);
            if (mmap.size() > 2) {
                mmap.put(fruits[i], mmap.get(fruits[i]) - 1);
                mmap.remove(fruits[i++], 0);
            }
        }
        return j - i;
    }
}

/**
 * if (mmap.get(ele[i]) == 0) mmap.remove(ele[i]) -> mmap.remove(ele[i], 0)
 * The above can be simplified if the key exists
 *
 * Instead of the While(mmap.size() > 2) We can use if statement
 * this also works as we are trying to maximize the window and that the maximum window
 * up until some j is retained into the next iterations as it possibly cannot reduce
 * because in each iteration we either increment both j and i which retains the window same length
 * or we maximise the window by incrementing just the j and skipping incrementing i
 * At end we return (j - i) which contains the maximum window length (the one which is retained
 * or the one which is the maximum window at the last iteration)
 */