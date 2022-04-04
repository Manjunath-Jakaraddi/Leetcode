package topinterview.strings;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/885/
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        for(int i=0; i<= haystack.length() - needle.length(); i++) {
            boolean found = true;
            for(int j=0; j<needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
