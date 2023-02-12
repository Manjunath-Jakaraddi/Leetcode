package contests.biweekly._85;

public class ProblemA {
    public int minimumRecolorsMinimising(String blocks, int K) {
        int N = blocks.length();
        int res = Integer.MAX_VALUE;
        int whites = 0;
        for (int i=0; i<N; i++) {
            if (blocks.charAt(i) == 'W') {
                whites++;
            }
            // start subtracting from K to transition to next window
            if (i >= K && blocks.charAt(i-K) == 'W') {
                whites--;
            }
            // start checking from K-1 as window is already formed
            if (i >= (K-1)) res = Math.min(res, whites);

        }
        return res;
    }

    public int minimumRecolorsMaximising(String blocks, int K) {
        int N = blocks.length();
        int blacks = 0;
        int res = 0;
        for (int i=0; i<N; i++) {
            if (blocks.charAt(i) == 'B') {
                blacks++;
            }
            if (i >= K && blocks.charAt(i-K) == 'B') {
                blacks--;
            }
            res = Math.max(res, blacks);
        }
        return K - res;
    }
}
