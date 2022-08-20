package random.graphs;

import java.util.*;

public class ReconstructItinerary_332 {
    Map<String, LinkedList<String>> mmap = new HashMap<>();
    LinkedList<String> res;
    int N;
    public List<String> findItinerary(List<List<String>> tickets) {
        N = tickets.size();
        res = new LinkedList<>();
        for(List<String> ticket : tickets) {
            if (!mmap.containsKey(ticket.get(0))) {
                mmap.put(ticket.get(0), new LinkedList<>());
            }
            mmap.get(ticket.get(0)).add(ticket.get(1));
        }
        for (Map.Entry<String, LinkedList<String>> entry : mmap.entrySet()) {
            Collections.sort(entry.getValue());
        }
        eulerianPath("JFK");
        return res;
    }
    private void eulerianPath(String u) {
        if (mmap.containsKey(u)) {
            // If some nodes unexplored exist even after dfs keep on exploring
            while (!mmap.get(u).isEmpty()) {
                String v = mmap.get(u).pollFirst();
                eulerianPath(v);
            }
        }
        // If none to explore add to list and backtrack the dfs path
        res.offerFirst(u);
    }

    Map<String, Integer> vis = new HashMap<>();
    public List<String> findItineraryMine(List<List<String>> tickets) {
        N = tickets.size();
        for(List<String> ticket : tickets) {
            if (!mmap.containsKey(ticket.get(0))) {
                mmap.put(ticket.get(0), new LinkedList<>());
            }
            mmap.get(ticket.get(0)).add(ticket.get(1));
            String edge = ticket.get(0) + "->" + ticket.get(1);
            vis.put(edge, vis.getOrDefault(edge, 0) + 1);
        }
        for (Map.Entry<String, LinkedList<String>> entry : mmap.entrySet()) {
            Collections.sort(entry.getValue());
        }
        res = new LinkedList<>();
        res.add("JFK");
        dfs("JFK");
        return res;
    }

    boolean dfs(String u) {
        if (res.size() == N + 1) {
            return true;
        }
        if (!mmap.containsKey(u))
            return false;
        for (String v : mmap.get(u)) {
            String edge = u + "->" + v;
            if (vis.get(edge) > 0) {
                res.add(v);
                vis.put(edge, vis.get(edge) - 1);
                if (dfs(v)) {
                    return true;
                }
                res.remove(res.size()-1);
                vis.put(edge, vis.get(edge) + 1);
            }
        }
        return false;
    }
}

/**
 * First approach with backtrack: so will take E^d need to optimize it
 * This problem related to Eulerian Path
 */
