package topinterview.strings;

import java.util.HashMap;
import java.util.Map;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/881/
public class FirstUniqCharacter {
    public int firstUniqChar(String s) {
        Map<Character, Integer> mmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mmap.put(s.charAt(i), mmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (mmap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Trick:
 * Since the letters are all small cased just use a fixed array instead of map
 */
