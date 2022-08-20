package company.google.arraysandstring;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int N = height.length;
        int l = 0, r = N-1, res = 0;
        while(l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
