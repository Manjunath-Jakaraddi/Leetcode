package contests.weekly._291;

import java.util.HashMap;
import java.util.Map;

public class ProblemB {
    public static void main(String[] args) {

    }

    public int minimumCardPickup(int[] cards) {
        int N = cards.length;
        int res = -1;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hmap.containsKey(cards[i])) {
                res = Math.max(res, i - hmap.get(cards[i] + 1));
            }
            hmap.put(cards[i], i);
        }
        return res;
    }
}
