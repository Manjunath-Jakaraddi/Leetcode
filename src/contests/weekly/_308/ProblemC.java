package contests.weekly._308;

public class ProblemC {
    public int garbageCollection(String[] garbage, int[] travel) {
        char[] item = new char[] {'M', 'P', 'G'};
        int[] lastInd = new int[] { -1, -1, -1};
        int[] sum = new int[3];
        int N = garbage.length;
        for (int i=0; i<N; i++) {
            for (int j = 0; j<garbage[i].length(); j++) {
                for (int k = 0; k < 3; k++) {
                    if (garbage[i].charAt(j) == item[k]) {
                        lastInd[k] = i;
                        sum[k]++;
                    }
                }
            }
            if (i > 0 && i < N-1) travel[i] += travel[i-1];
        }
        int res = 0;
        for (int i=0; i<3; i++) {
            res += sum[i];
            if (lastInd[i] > 0) {
                res += travel[lastInd[i] - 1];
            }
        }
        return res;
    }
}
