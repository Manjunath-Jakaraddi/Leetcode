package contests.biweekly._80;

import java.util.Arrays;

public class ProblemB {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int S = spells.length, P = potions.length;
        int[] res = new int[S];
        for (int i = 0; i < S; i++) {
            int ind = lower_bound(potions, (int)Math.ceil((double)success / spells[i]));
            if (ind == -1) {
                res[i] = 0;
            } else {
                res[i] = (P - ind);
            }
        }
        return res;
    }

    private int lower_bound(int[] arr, int key) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left < arr.length && arr[left] < key) {
            return -1;
        }
        return left;
    }
}
