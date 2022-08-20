package contests.weekly._306;

public class ProblemB {
    public int edgeScore(int[] edges) {
        int N = edges.length;
        long[] score = new long[N];
        long mxScore = -1;
        int mxNode = -1;
        for (int i=0; i<N; i++) {
            score[edges[i]]+=(long)i;
            mxScore = Math.max(mxScore, score[edges[i]]);
        }
        for (int i=0; i<N; i++) {
            if (mxScore == score[i]) {
                mxNode = i;
                break;
            }
        }
        return mxNode;
    }
}
