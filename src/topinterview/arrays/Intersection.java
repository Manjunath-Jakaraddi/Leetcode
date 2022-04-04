package topinterview.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Link:- https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/
public class Intersection {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num : nums1) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        for(int num: nums2) {
            if(hmap.containsKey(num) && hmap.get(num) > 0) {
                res.add(num);
                hmap.put(num, hmap.get(num) - 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * Revise
 * returning int[] from List<Integer>
 * Follow up: when sorted?
 *      Use two pointer compare if equal add to res else increment the lower one
 */