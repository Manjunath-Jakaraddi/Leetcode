package contests.weekly._295;

import java.util.Scanner;
import java.util.Stack;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(totalSteps(arr));
    }

    private static int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int N = nums.length, cnt = 0, ans = 0;
        stack.add(new int[]{nums[N-1], 0});
        for (int i = N-2; i >=0 ; i--) {
            cnt = 0;
            while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                cnt = Math.max(cnt + 1, stack.peek()[1]);
                stack.pop();
            }
            ans = Math.max(ans, cnt);
            stack.push(new int[] {nums[i], cnt});
        }
        return ans;
    }

}