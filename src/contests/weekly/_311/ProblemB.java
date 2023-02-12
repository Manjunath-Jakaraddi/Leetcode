package contests.weekly._311;

public class ProblemB {
    public int longestContinuousSubstring(String s) {
        int res = 1, N = s.length(), j=0;
        for (int i=1; i<N; i++) {
            if (s.charAt(i) != s.charAt(j) + i - j) {
                j = i;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
