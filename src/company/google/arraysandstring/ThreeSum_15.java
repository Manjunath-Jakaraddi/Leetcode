package company.google.arraysandstring;

import java.util.*;

public class ThreeSum_15 {
    public List<List<Integer>> threeSumNoSort(int[] nums) {
        Map<Integer, Boolean> mmap = new HashMap<>();
        Map<String, Boolean> check = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        mmap.put(nums[0], true);
        int N = nums.length;
        for (int i=1; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                int rem = -nums[i]-nums[j];
                if (mmap.containsKey(rem)) {
                    int[] ele = new int[] {rem, nums[i], nums[j]};
                    Arrays.sort(ele);
                    String str = ele[0] + "," + ele[1] + "," + ele[2];
                    if (!check.containsKey(str)) {
                        res.add(Arrays.asList(ele[0], ele[1], ele[2]));
                        check.put(str, true);
                    }
                }
            }
            mmap.put(nums[i], true);
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                // if the num is same as prev then don't waste by computing and also avoids duplicates
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    private void twoSumUnsorted(int[] nums, int i, List<List<Integer>> res) {
        Map<Integer, Boolean> seen = new HashMap<>();
        for (int j = i+1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if (seen.containsKey(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                // To avoid duplicates skip all the equal two pairs same strategy as above
                while (j + 1 < nums.length && nums[j+1] == nums[j])
                    j++;
            }
            seen.put(nums[j], true);
        }
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            } else {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++; r--;
                while (l < r && nums[l] == nums[l-1])   l++;
                // To avoid duplicates
            }
        }
    }


    /**
     * Unsorted version using map to check the previous and the strings to check the uniqueness
     * uniqueness can also be checked by Set<List<Integer>>
     *
     * Interview use the sort version as more efficient
     * the no-sort one will be (memory) efficient when there are many duplicates and few triplets
     * For sorted version we traverse the first element for all the negative numbers
     * and for the next two numbers we use the two sum approach (two pointer or the hashmap one)
     * One more adv of sorting numbers is no need to check for uniqueness
     *
     * Most efficient as per leetcode runtime -> sorted with two pointer approach
     */
}
