package contests.biweekly._81;

public class ProblemA {
    public int countAsterisks(String s) {
        boolean count = true;
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '|')  count = !count;
            if (ch == '*' && count) res++;
        }
        return res;
    }
}
