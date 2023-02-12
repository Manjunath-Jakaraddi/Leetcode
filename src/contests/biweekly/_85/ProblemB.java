package contests.biweekly._85;

public class ProblemB {

    public int secondsToRemoveOccurrencesBruteForceSimulation(String inp) {
        boolean changed = true;
        int time = 0;
        int N = inp.length();
        char[] s = inp.toCharArray();
        while (changed) {
            changed = false;
            for (int i=0; i<N-1; i++) {
                if (s[i] == '0' && s[i+1] == '1') {
                    changed = true;
                    char temp = s[i+1];
                    s[i+1] = s[i];
                    s[i] = temp;
                    i++;
                }
            }
            if (changed) {
                time++;
            }
        }
        return time;
    }

    public int secondsToRemoveOccurrencesMyDP(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        int zerosCount = 0;
        int res = 0, i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            zerosCount++;
            i++;
        }
        for (; i<s.length(); i++) {
            if (s.charAt(i) == '0') {
                res = Math.max(res+1, i - zerosCount);
                zerosCount++;
            }
        }
        return res;
    }

    public int secondsToRemoveOccurrences(String s) {
        int zeros = 0, seconds = 0;
        for (int i = 0; i < s.length(); ++i) {
            zeros += s.charAt(i) == '0' ? 1 : 0;
            if (s.charAt(i) == '1' && zeros > 0)
                seconds = Math.max(seconds + 1, zeros);
        }
        return seconds;
    }

}

/**
 * My solution was thinking w.r.t zeros
 * it can also be solved using a similar approach w.r.t ones and no need to reverse the
 * string as well in that case but for understanding use the zeros first
 */
