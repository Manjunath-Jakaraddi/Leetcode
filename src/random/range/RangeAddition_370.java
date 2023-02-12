package random.range;

public class RangeAddition_370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] u : updates) {
            res[u[0]] += u[2];
            if (u[1] != length-1) {
                res[u[1] + 1] -= u[2];
            }
        }
        for (int i=1; i<length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }
}

/**
 * TODO:
 * This problem has the initial array values starting at zero's
 * What if another array was given as input
 * Then we need to first change the input array cumulative differences
 * for i : 1 -> n
 *      inpArr[i] = inpArr[i] - inpArr[i-1]
 * which then will become our res array in this problem (although not all are zeros
 * it contains the input array information if we perform the prefix sum)
 *
 * Then continue the same steps as in this problem to get the answer
 * with the inpArr instead of res array.
 *
 * In final step the inpArr will have the ans
 */
