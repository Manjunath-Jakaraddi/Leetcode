package contests.weekly._310;

public class ProblemB {
    public int partitionString(String s) {
        int res = 1, mask = 0;
        for (int i=0; i<s.length();i++) {
            if ((mask & (1 << (s.charAt(i) - 'a'))) != 0) {
                res++;
                mask = (1 << (s.charAt(i) - 'a'));
            } else {
                mask |= (1 << (s.charAt(i) - 'a'));
            }
        }
        return res;
    }
}
