package contests.weekly._291;

public class ProblemC {
    private int N;
    private boolean[][] trie;
    public int countDistinct(int[] nums, int k, int p) {
        N = nums.length;
        trie = new boolean[N+1][201];
        int res = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if (isValid(nums, i, j, k, p) && !ifExists(nums, i, j)) {
                    res++;
                }
            }
        }
        return res + N;
    }

    private boolean ifExists(int[] nums, int i, int j) {
        boolean exists = true;
        int ind = 0;
        for (int k = i; k <= j; k++) {
            if (!trie[ind][nums[k]]) {
                trie[ind][nums[k]] = true;
                if (exists) {
                    exists = false;
                }
            }
            ind++;
        }
        return exists;
    }

    private boolean isValid(int[] nums, int i, int j, int k, int p) {
        int count = 0;
        for (int l = i; l <= j; l++) {
            if (nums[l] % p == 0) {
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }


}
