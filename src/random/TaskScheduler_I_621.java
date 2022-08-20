package random;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class TaskScheduler_I_621 {
    public int leastIntervalWithPQAndQueue(char[] tasks, int d) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<int[]> dq = new ArrayDeque<>();
        for(int f : freq) {
            if(f != 0) pq.add(-f);
        }
        int time = 0;
        while (!pq.isEmpty() || !dq.isEmpty()) {
            time++;
            int curr = (pq.isEmpty() ? -1: pq.poll());
            curr++;
            if (curr != 0) {
                dq.add(new int[]{curr, time+d});
            }
            if (!dq.isEmpty() && dq.peekFirst()[1] == time) {
                pq.add(dq.pollFirst()[0]);
            }
        }
        return time;
    }

    public int leastIntervalApproach1(char[] tasks, int d) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        Arrays.sort(freq);
        int fMax = freq[25];
        int idle = (fMax - 1) * d;
        for (int i = 24; i >= 0 && idle > 0; i--) {
            idle -= Math.min(fMax - 1, freq[i]);
        }
        return tasks.length + Math.max(0, idle);
    }
    /**
     * Math.min(fMax - 1, freq[i]) -> because if the fMax is repeating more than once
     * then the gaps(idle slots) that needs to subtracted are equal to (fMax - 1) as the
     * last one (the extra B) will be greater than last fMax element (A).
     * eg. A-> 4, B -> 4, C -> 1
     * A, B, C, A, B, idle, A, B, idle, A, B
     */

    public int leastIntervalMath(char[] tasks, int d) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        int fMax = 0, nMax = 0;
        for (int i = 0; i<26; i++) {
            fMax = Math.max(fMax, freq[i]);
        }
        for (int i = 0; i<26; i++) {
            if (freq[i] == fMax)    nMax++;
        }
        return Math.max(tasks.length, (fMax - 1) * (d + 1) + nMax);
    }
    /**
     * All the cases can be handled in Math
     * 1. The most frequent task is not frequent enough to force the presence of idle slots.
     *    When the other elements apart from the one with max freq overflows
     *    A-> 4, C,D,E,F,G,H,I -> others 7 -> in this case the ans will be length of the input
     *
     * 2. The most frequent task is frequent enough to force some idle slots.
     *    In this case we consider the (fMax - 1) * d but what if there are multiple
     *    max frequencies (Nmax). Then we need to accommodate multiple max freq elements by adding that number
     *    (fMax - 1) * (d+1) + Nmax -> (d+1) because we are not counting idle slots but all the slots
     */

}
