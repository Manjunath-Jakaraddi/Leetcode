package topinterview.strings;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/879/
public class Reverse {
    public void reverseString(char[] s) {
        for(int i=0; i<s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
