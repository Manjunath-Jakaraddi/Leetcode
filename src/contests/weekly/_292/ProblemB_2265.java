package contests.weekly._292;



//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
 }

public class ProblemB_2265 {
    private int res = 0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }

    private int solve(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            res++;
            return 1;
        }
        int by = 1 + solve(node.left) + solve(node.right);
        int currSum = node.val + (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);

        int avg = currSum / by;
        if (node.val == avg) {
            res++;
        }
        node.val = currSum;
        return by;
    }
}
