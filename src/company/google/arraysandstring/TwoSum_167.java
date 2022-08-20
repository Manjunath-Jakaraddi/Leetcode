package company.google.arraysandstring;

public class TwoSum_167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int num = numbers[l] + numbers[r];
            if (num == target) {
                return new int[] {l+1, r+1};
            } else if (num < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[] {-1, -1};
    }
    /**
     * Two pointer approach as array is sorted else would've used the map approach
     */
}
