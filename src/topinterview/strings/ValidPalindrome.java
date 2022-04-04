package topinterview.strings;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/883/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        s = sb.toString();
        int n = s.length();
        for (int i=0; i< n/2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Revise:- <String>.toLowerCase()
 * Character.isAlphabetic(<ch>) .isDigit(ch)
 */