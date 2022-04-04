package topinterview.strings;

//Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/882/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        for(char ch : s.toCharArray()) {
            cnt[(ch - 'a')]++;
        }
        for (char ch: t.toCharArray()) {
            cnt[(ch - 'a')]--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
