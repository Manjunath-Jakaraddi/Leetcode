package random;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (res.size() == 0) res.add(num);
            if (res.get(res.size()-1) < num) {
                res.add(num);
            } else {
                int insertInd = binarySearch(res, num);
                res.set(insertInd, num);
            }
            if (res.size() == 3) {
                return true;
            }
        }
        return false;
    }
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (first >= num) {
                first = num;
            } else if (second >= num) {
                second = num;
            } else {
                // not equal to
                return true;
            }
        }
        return false;
    }

    int binarySearch(List<Integer> res, int key) {
        int l = 0, r = res.size() - 1;
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (res.get(mid) == key) {
                return mid;
            }
            if (res.get(mid) > key) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
