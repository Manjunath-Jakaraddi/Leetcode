package contests.weekly._304;

import java.util.Arrays;

public class ProblemC {
    int INF = 987654321;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) {
            return node1;
        }
        int N = edges.length;
        int[] dist1 = new int[N], dist2 = new int[N];
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        int curr = node1;
        dist1[curr] = 0;
        while (edges[curr] != -1) {
            int next = edges[curr];
            dist1[next] = dist1[curr] + 1;
            curr = next;
        }
        curr = node2;
        dist2[curr] = 0;
        while (edges[curr] != -1) {
            int next = edges[curr];
            dist2[next] = dist2[curr] + 1;
            curr = next;
        }
        int res = Integer.MAX_VALUE, ind = -1;
        for (int i = 0; i < N; i++) {
            if (dist1[i] != INF && dist2[i] != INF) {
                int mx = Math.max(dist1[i], dist2[i]);
                if (mx < res) {
                    res = mx;
                    ind = i;
                }
            }
        }
        return ind;
    }
}
