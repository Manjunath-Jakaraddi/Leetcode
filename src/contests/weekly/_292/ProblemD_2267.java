package contests.weekly._292;

import java.util.Stack;

public class ProblemD_2267 {

    // recursive timing out
    int N = 0, M = 0;
    Stack<Character> stack = new Stack<>();

    public boolean hasValidPath(char[][] grid) {
        N = grid.length;
        M = grid[0].length;
        return solve(grid, 0, 0);
    }

    boolean isValid(int x, int y) {
        return x >=0 && x < N && y >=0 && y < M;
    }
    boolean solve(char[][] grid, int x, int y) {
        if (!isValid(x, y)) {
            return false;
        }
        if (x == N-1 && y == M-1 && grid[x][y] == ')' && !stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            return true;
        }

        if (grid[x][y] == '(') {
            stack.push('(');
            return solve(grid, x + 1, y) || solve(grid, x, y+1);
        } else if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            return solve(grid, x+1, y) || solve(grid, x, y+1);
        }
        return false;
    }


    // Trying 3D - dp approach
    boolean[][][] dp = new boolean[101][101][101];
    public boolean hasValidPath2(char[][] grid) {
        N = grid.length; M = grid[0].length;
        return hasValidPath(grid, 0, 0, 0);
    }

    private boolean hasValidPath(char[][] grid, int x, int y, int bal) {
        bal += (grid[x][y] == '(' ? 1 : -1);
        if (bal < 0 || bal > ((M + N) / 2) || dp[x][y][bal]) {
            return false;
        }
        dp[x][y][bal] = true;
        if (x == N-1 && y == M-1 && bal == 0) {
            return true;
        }
        if (x < N-1 && hasValidPath(grid, x+1, y, bal)) {
            return true;
        }
        if (y < M-1 && hasValidPath(grid, x, y+1, bal)) {
            return true;
        }
        return false;
    }

}
