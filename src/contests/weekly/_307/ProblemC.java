package contests.weekly._307;

import java.util.*;

public class ProblemC {
    private int res = 0;

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return res;
    }

    Pair<Boolean, Integer> dfs(TreeNode root, int start) {
        if (root == null) {
            return new Pair(false, 0);
        }

        Pair<Boolean, Integer> p1 = dfs(root.left, start);
        Pair<Boolean, Integer> p2 = dfs(root.right, start);

        // At the start node
        if (root.val == start) {
            int temp = Math.max(p1.second, p2.second);
            res = Math.max(res, temp);
            return new Pair(true, 0);
        }

        // When found the start node
        int sum = p1.second + 1 + p2.second;
        if (p1.first) {
            res = Math.max(res, sum);
            return new Pair(true, p1.second + 1);
        } else if (p2.first) {
            res = Math.max(res, sum);
            return new Pair(true, p2.second + 1);
        }

        // When not found the start node
        sum = Math.max(p1.second, p2.second);
        return new Pair(false, sum + 1);
    }

    public int amountOfTimeLayeredBFS(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        dfsPopulate(root, null, map);
        Set<Integer> st = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        st.add(start);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int next : map.getOrDefault(curr, new HashSet<>())) {
                    if (st.add(next)) {
                        q.offer(next);
                    }
                }
            }
            res++;
        }
        return res - 1;
    }

    void dfsPopulate(TreeNode curr, TreeNode par, Map<Integer, Set<Integer>> map) {
        if (curr == null)   return;
        if (par != null) {
            map.putIfAbsent(par.val, new HashSet<>());
            map.get(par.val).add(curr.val);
            map.putIfAbsent(curr.val, new HashSet<>());
            map.get(curr.val).add(par.val);
        }
        dfsPopulate(curr.left, curr, map);
        dfsPopulate(curr.right, curr, map);
    }
    static class Pair<T, U>
    {
        T first;
        U second;
        Pair()
        {
            //default constructor
        }

        Pair(T a, U b)
        {
            this.first = a;
            this.second = b;
        }
        void setValue(T a, U b)
        {
            this.first = a;
            this.second = b;
        }
        Pair getValue()
        {
            return this;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * TODO: Revise Layered BFS
 */
