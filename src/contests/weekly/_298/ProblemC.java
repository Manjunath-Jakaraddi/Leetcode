package contests.weekly._298;

public class ProblemC {

    public static void main(String[] args) {
        System.out.println(longestSubsequence("0111101", 518459120));
    }

    public static int longestSubsequence(String s, int k) {
        int N = s.length();
        int countZeros = (int) s.chars().filter(ch -> ch == '0').count();
        int pow = 1, val = 0, countOnes = 0;
        for (int i = N-1; i >= 0 && val+pow <= k; i--) {
            if (s.charAt(i) == '1') {
                countOnes++;
                val += pow;
            }
            pow <<= 1;
        }
        return countZeros + countOnes;
    }
}

/**
 * TODO Revise
 * DP explore
 * Intuition to pick all zeros was correct,
 * however using the same greedy approach start choosing whichever possible one from right side
 */