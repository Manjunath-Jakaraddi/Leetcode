package random.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        int[] indeg = new int[N];
        List<Integer>[] adj = new List[N];
        for (int i=0; i<N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : prerequisites) {
            adj[edge[1]].add(edge[0]);
            indeg[edge[0]]++;
        }
        int reachable = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                reachable++;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj[curr]) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.add(next);
                    reachable++;
                }
            }
        }
        return reachable == N;
    }
}
