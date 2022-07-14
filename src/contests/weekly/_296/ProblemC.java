package contests.weekly._296;

import java.util.HashMap;
import java.util.Map;

public class ProblemC {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> elementsToIndex = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            elementsToIndex.put(nums[i], i);
        }
        int M = operations.length;
        for (int i = 0; i < M; i++) {
            int currInd = elementsToIndex.get(operations[i][0]);
            nums[currInd] = operations[i][1];
            elementsToIndex.remove(operations[i][0]);
            elementsToIndex.put(operations[i][1], currInd);
        }
        return nums;
    }
}
