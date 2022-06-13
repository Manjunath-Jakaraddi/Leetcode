package contests.weekly._291;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(appealSum(str));
    }

    // TLE
    public static long appealSum(String s) {
        int N = s.length();
        int[] masks = new int[N+1];
        Arrays.fill(masks, 0);
        int msk = 0;
        long res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = N; j >=i; j--) {
                msk = (1 << (s.charAt(j-1) - 'a'));
                masks[j] = (msk | masks[j-1]);
                res += set_bits_count(masks[j]);
            }
        }
        return res;
    }

    static int set_bits_count(int num){
        int count = 0;
        while (num > 0){
            num &= (num - 1);
            count++;
        }
        return count;
    }


    // Optimized dp
    // As dp(i) substring appeal of length i first characters only (not total appeal)
    // is equal to dp(i-1) plus all the substrings previously that do not contain the character at (i)
    // if all were unique then we are looking at pattern like 1,2,3,4 increasing subarrays
    // but as there might be duplicate character we need to store their previous and exclude the
    // subarrays before them that's why we add (i - prev(character(i))
    // Then for the total appeal we sum over the entire dp
    // Dp can be space optimized as we only need previous state
    public long appealSum2(String s) {
        int N = s.length();
        int[] prev = new int[26];
        long ans = 1;
        Arrays.fill(prev, -1);
        int pr = 1, next = 0;
        prev[s.charAt(0) - 'a'] = 0;
        for(int i=1; i<N; i++) {
            next = pr + (i - prev[(s.charAt(i)-'a')]);
            prev[(s.charAt(i)-'a')] = i;
            ans += next;
            pr = next;
        }
        return ans;
    }


    // Instead of excluding the previous one we can also using combinatorics count the valid ones
    // For abcadcaa excluding the first a if we consider second a and the character after first a
    // and characters till end
    public long appealSum3(String s) {
        int N = s.length();
        int[] prev = new int[26];
        long ans = 0;
        for(int i=0; i<N; i++) {
            ans += ((N-i) * (i + 1 - prev[s.charAt(i) - 'a']));
            prev[(s.charAt(i)-'a')] = i+1;
        }
        return ans;
    }
}
