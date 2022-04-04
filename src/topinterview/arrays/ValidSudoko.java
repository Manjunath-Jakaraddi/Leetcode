package topinterview.arrays;

// Link:- https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/769/
public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        int[][] cols = new int[9][9];
        for (int i=0; i<9; i++) {
            int[] rows = new int[9];
            for(int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    int num = (board[i][j] - '0' - 1);
                    if(cols[j][num] == 1) {
                        return false;
                    } else if (rows[num] == 1) {
                        return false;
                    } else {
                        cols[j][num] = 1;
                        rows[num] = 1;
                    }
                }
            }
        }
        for(int i=0; i<9; i+=3) {
            for(int j=0; j< 9; j+=3) {
                if(!check(i, j, board)) return false;
            }
        }
        return true;
    }

    public boolean check(int row, int col, char[][] board) {
        int[] nums = new int[9];
        for(int i=row; i<row+3; i++) {
            for(int j=col; j<col+3; j++) {
                if(board[i][j] != '.') {
                    int num = (board[i][j] - '0' - 1);
                    if (nums[num] == 1) {
                        return false;
                    } else {
                        nums[num] = 1;
                    }
                }
            }
        }
        return true;
    }
}
