package contests.biweekly._81;

public class ProblemC {
    public int maximumXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res |= num;
        }
        return res;
    }
}
/**
 * Good job!! your logic worked here
 * as you can use any number you can eliminate (make them zero) all the non required numbers
 *  which are not contributing to the ones in the final answer (as we want maximum XOR in end)
 *  All in the elements considered for final XOR whic have even ones can also be eliminated by
 *  same strategy. So in end we are left with columns having atleast one 1 bit and columns with
 *  all zeros can be done nothing.So the final answer will be OR of all elements
 */

/*

0001
0010
0011
1001
0010

1011


011
010
100
110

111
*/