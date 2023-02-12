package contests.biweekly._85;

public class ProblemC {
    public String shiftingLetters(String s, int[][] shifts) {
        int S = shifts.length;
        int N = s.length();
        int[] eff = new int[N+1];
        for (int[] ele : shifts) {
            int start = ele[0], end = ele[1], dir = ele[2] == 1 ? 1 : -1;
            eff[start] += dir;
            eff[end+1] -= dir;
        }
        int sum = 0;
        StringBuilder res = new StringBuilder();
        for (int i=0; i<N; i++) {
            sum = (sum + 26 + eff[i]) % 26;
            int next = (s.charAt(i) - 'a' + sum + 26) % 26;
            char newChar = (char) (next + 'a');
            res.append(newChar);
        }
        return res.toString();
    }
}
