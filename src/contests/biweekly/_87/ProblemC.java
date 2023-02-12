package contests.biweekly._87;


import java.util.LinkedList;
import java.util.Queue;

public class ProblemC {
    public int[] smallestSubarrays(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return new int[] {1};
        }
        Queue<Integer>[] freq = new Queue[32];
        for (int i=0; i<32; i++) {
            freq[i] = new LinkedList<>();
        }
        for (int i=0; i<N; i++) {
            int num = nums[i];
            for (int b=0; b<32; b++) {
                if ((num & (1 << b)) != 0) {
                    freq[b].add(i+1);
                }
            }
        }

        int[] res = new int[N];
        for (int i=0; i<N; i++) {
            int maxInd = -1;
            for (int b=0; b<32; b++) {
                if (!freq[b].isEmpty()) {
                    maxInd = Math.max(maxInd, freq[b].peek());
                }
            }
            if (maxInd != -1) {
                res[i] = maxInd - i;
            } else {
                res[i] = 1;
            }
            for (int b=0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    freq[b].poll();
                }
            }
        }
        return res;
    }

    public int[] smallestSubarraysOptimized(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        int[] last = new int[30];
        for (int i=N-1; i>=0; i--) {
            res[i] = 1;
            for (int j=0; j<30; j++) {
                if ((nums[i] & (1<<j)) != 0) {
                    last[j] = i;
                }
                res[i] = Math.max(res[i], last[j] - i + 1);
            }
        }
        return res;
    }
}
