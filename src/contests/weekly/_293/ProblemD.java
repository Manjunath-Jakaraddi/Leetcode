package contests.weekly._293;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = "";
        CountIntervals inst = new CountIntervals();
        while (!inp.equals("E")) {
            inp = sc.next();
            switch (inp) {
                case "A":
                    int left = sc.nextInt();
                    int right = sc.nextInt();
                    inst.add(left, right);
                    break;
                case "C":
                    System.out.println(inst.count());
            }
        }
    }
}

class CountIntervals {
    TreeMap<Integer, Integer> m = new TreeMap<>();
    int cnt = 0;
    public void add(int left, int right) {
        Map.Entry<Integer, Integer> it = m.floorEntry(left);
        if (it == null || it.getValue() < left)
            it = m.higherEntry(left);
        for (; it != null && it.getKey() <= right; it = m.higherEntry(left)) {
            left = Math.min(left, it.getKey());
            right = Math.max(right, it.getValue());
            cnt -= it.getValue() - it.getKey() + 1;
            m.remove(it.getKey());
        }
        m.put(left, right);
        cnt += right - left + 1;
    }
    public int count() { return cnt; }
}