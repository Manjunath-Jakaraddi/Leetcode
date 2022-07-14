package standardleetcode;

import java.util.Stack;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] heights = {3, 2, 1, 0, 0, 0, 1, 3};
        System.out.println(trap2(heights) == trap3(heights));
    }

    public int trap(int[] height) {
        int N = height.length;
        int[] leftMax = new int[N], rightMax = new int[N];
        leftMax[0] = height[0];
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[N-1] = height[N-1];
        for (int i = N-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public static int trap2(int[] height) {
        int N = height.length;
        Stack<Integer> stack = new Stack<>();
        int ind = 0, ans = 0;
        while (ind < N) {
            while (!stack.isEmpty() && height[ind] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = ind - stack.peek() - 1;
                int bounded_height = Math.min(height[ind], height[stack.peek()]) - height[top];
                ans += (distance * bounded_height);
            }
            stack.add(ind++);
        }
        return ans;
    }

    public static int trap3(int[] heights) {
        int left = 0, right = heights.length - 1;
        int ans = 0, left_max = 0, right_max = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                if (heights[left] >= left_max) {
                    left_max = heights[left];
                } else {
                    ans += (left_max - heights[left]);
                }
                left++;
            } else {
                if (heights[right] >= right_max) {
                    right_max = heights[right];
                } else {
                    ans += (right_max - heights[right]);
                }
                right--;
            }
        }
        return ans;
    }
}
