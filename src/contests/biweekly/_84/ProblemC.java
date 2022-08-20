package contests.biweekly._84;

import java.util.*;

public class ProblemC {
    public long taskSchedulerIIUnOptimizedMine(int[] input, int n) {
        Map<Long, Boolean> mmap = new HashMap<>();
        Deque<long[]> dq = new ArrayDeque<>();
        // 0 -> time, 1 -> element

        long[] tasks = Arrays.stream(input).mapToLong(i -> i).toArray();
        long d = n;
        long time = 0;
        for (int i=0; i<tasks.length; i++) {
            time++;

            while(!dq.isEmpty() && mmap.containsKey(tasks[i])) {
                long[] ele = dq.pollFirst();
                mmap.remove(ele[1]);
                time = ele[0]+1;
            }
            while (!dq.isEmpty() && dq.peekFirst()[0] <= time) {
                long[] ele = dq.pollFirst();
                mmap.remove(ele[1]);
            }
            mmap.put(tasks[i], true);
            dq.add(new long[]{time+d, tasks[i]});
        }
        return time;
    }

    public long taskSchedulerII(int[] tasks, int space) {
        long time = 0;
        Map<Integer, Long> mmap = new HashMap<>();
        for (int i = 0; i<tasks.length; i++) {
            // while adding next element pick the max of placement time of the element from map or the current time
            time = Math.max(time + 1, mmap.getOrDefault(tasks[i], 0L));
            // add the time in the map where the next element can be placed
            mmap.put(tasks[i], time + space + 1);
        }
        return time;
    }
}
