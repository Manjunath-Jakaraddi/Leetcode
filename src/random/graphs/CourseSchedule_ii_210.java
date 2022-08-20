package random.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_ii_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (int next : adj[curr]) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (res.size() < numCourses) {
            return new int[]{};
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
