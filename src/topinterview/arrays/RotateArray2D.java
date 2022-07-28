package topinterview.arrays;

// Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/770/
public class RotateArray2D {
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i < (n+1)/2; i++) {
            for(int j=0; j < n/2; j++) {
                int temp = matrix[i][j]; // i=0, j=1
                matrix[i][j] = matrix[n-1-j][i]; // 1, 0
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];

                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reflect(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}

/**
 * Revise: Trick
 * 1) To rotate with every element four time
 *  Tip1: Take (0,1) cell to trace
 *          and remember i will be upto (n+1/2) and j will be n/2
 *          as need to rotate all the elements(including middle one) in the row upto half columns
 * 2) Also, can be done via transpose (over the diagonal)
 *      and then reversing along the half line.
 *
 *
 */
