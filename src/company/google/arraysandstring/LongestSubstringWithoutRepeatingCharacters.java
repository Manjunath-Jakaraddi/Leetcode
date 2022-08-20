package company.google.arraysandstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringMine(String s) {
        int N = s.length();
        if (N < 2) return N;
        char[] ch = s.toCharArray();
        int l = 0, r = 1, res = 0;
        int[] map = new int[256];
        map[ch[0]] = 1;
        while(r < N) {
            while(r < N && map[ch[r]] == 0) {
                map[ch[r]] = 1;
                r++;
            }
            res = Math.max(res, r - l);
            while(r < N && map[ch[r]] == 1) {
                map[ch[l]]--;
                l++;
            }
            if (r < N) {
                map[ch[r]]++;
                r++;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mmap = new HashMap<>();
        int N = s.length(), ans = 0;
        for (int j = 0, i = 0; j < N; j++) {
            if (mmap.containsKey(s.charAt(j))) {
                i = Math.max(i, mmap.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            mmap.put(s.charAt(j), j+1);
        }
        return ans;
    }
}

/**
 * Read optimized moving window technique
 * Finished: The optimized versions instead of moving the left one by one
 * remembers the last occurence of the character in a map and then moves
 * directly to the next step as moving one by one left is inefficient
 */