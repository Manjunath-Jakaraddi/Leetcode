package random.trees;

public class CountGoodNodes_1448 {
    public int goodNodes(TreeNode root) {
        return solve(root, root.val);
    }

    int solve(TreeNode curr, int max) {
        if (curr == null) {
            return 0;
        }
        int cnt = 0;
        if (curr.val >= max) {
            cnt++;
        }
        int nextMax = Math.max(max, curr.val);
        cnt += solve(curr.left, nextMax);
        cnt += solve(curr.right, nextMax);
        return cnt;
    }
    public class TreeNode {
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
}
