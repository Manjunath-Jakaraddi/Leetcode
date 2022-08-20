package contests.weekly._303;

public class ProblemA {
    public char repeatedCharacter(String s) {
        int mask = 0;
        for(char c : s.toCharArray()) {
            int m = (1 << (c - 'a'));
            if ((mask & m) != 0) {
                return c;
            }
            mask |= m;
        }
        return 'a';
    }
}
