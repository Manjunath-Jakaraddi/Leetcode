package contests.biweekly._80;

import java.util.HashSet;
import java.util.Set;

public class ProblemA {
    public boolean strongPasswordCheckerII(String password) {
        int N = password.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            char c = password.charAt(i);
            if (i > 0 && password.charAt(i-1) == c) {
                return false;
            }
            if (Character.isUpperCase(c)) {
                set.add('u');
            } else if (Character.isLowerCase(c)) {
                set.add('l');
            } else if (Character.isDigit(c)) {
                set.add('d');
            } else  {
                set.add('s');
            }
        }
        return password.length() >= 8 && set.size() == 4;
    }
}
