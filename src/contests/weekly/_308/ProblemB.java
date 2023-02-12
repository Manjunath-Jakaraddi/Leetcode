package contests.weekly._308;

public class ProblemB {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int N = s.length();
        int count = 0;
        for (int i=N-1; i>=0; i--) {
            if (s.charAt(i) == '*') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.reverse().toString();
    }
}
