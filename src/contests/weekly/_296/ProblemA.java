package contests.weekly._296;

public class ProblemA {
    int N;
    public int minMaxGame(int[] nums) {
        N = nums.length;
        return solve(nums, 0, N-1, 0);
    }

    private int solve(int[] nums, int left, int right, int toggle) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + ((right - left) >> 1);
        if (toggle == 0) {
            return Math.min(solve(nums, left, mid, 0), solve(nums, mid+1, right, 1));
        } else {
            return Math.max(solve(nums, left, mid, 0), solve(nums, mid+1, right, 1));
        }
    }
}
