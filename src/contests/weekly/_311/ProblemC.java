package contests.weekly._311;

import java.util.*;

public class ProblemC {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOptimized(root.left, root.right, 0);
        return root;
    }

    void reverseOptimized(TreeNode node1, TreeNode node2, int level) {
        if (node1 == null) {
            return;
        }
        if (level % 2 == 0) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        // Use symmetry to solve left and right reverse
        reverseOptimized(node1.left, node2.right, level+1);
        reverseOptimized(node1.right, node2.left, level+1);
    }

    public TreeNode reverseOddLevelsUnOptimized(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            Queue<TreeNode> tmpQueue = new LinkedList<>();

            List<Integer> lst = new ArrayList<>();
            for (int size=sz; size > 0; size--) {
                TreeNode curr = queue.poll();
                tmpQueue.add(curr);
                if (curr.left != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                lst.add(curr.val);
            }
            Collections.reverse(lst);
            if (level % 2 != 0) {
                for (int size=0; size < sz; size++) {
                    TreeNode curr = tmpQueue.poll();
                    curr.val = lst.get(size);
                }
            }
            level++;
        }
        return root;
    }


    public class TreeNode {
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


