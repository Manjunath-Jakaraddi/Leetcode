package contests.weekly._306;

public class ProblemC {

    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
        System.out.println(smallestNumber("DDD"));
    }
    static int N;
    static char[] pat;
    static String ans;
    public static String smallestNumber(String pattern) {
        pat = pattern.toCharArray();
        N = pat.length + 1;
        ans = "";
        boolean r = false;
        for (int i=1; i<10; i++) {
            r = solve(1<<(i-1), 1, "" + i);
            if (r) {
                break;
            }
        }
        return ans;
    }

    static boolean solve(int mask, int pos, String res) {
        if (mask == ((1<<N) - 1) && pos == N) {
            ans = res;
            return true;
        }
        if (pos >= N) {
            return false;
        }
        for (int i=1; i<10; i++) {
            if (((1 << (i-1)) & mask) == 0) {
                boolean r = false;
                if (pat[pos-1] == 'I' && res.charAt(pos-1) < (i + '0')) {
                    r = solve(mask | ((1 << (i-1))), pos+1, res + i);
                } else if (pat[pos-1] == 'D' && res.charAt(pos-1) > ('0' + i)) {
                    r = solve(mask | ((1 << (i-1))), pos+1, res + i);

                }
                if (r) {
                    return true;
                }
            }
        }
        return false;
    }

    public String smallestNumber2(String pattern) {
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char)('1' + i));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }
}


// (mask, position)
// mask -> which all numbers have been used till now
// will be used to find the next smallest allowed number
// position -> have we reached the nth position and also if not whether to choose increasing or decreasing
// will be used to see if we have completed the solution with the smalled number and that'll be our answer

/**
 * Good job solving it with idea of dp and dfs optimized approach
 * Another way to solve would be taking the least solution 123456789 and
 * reversing whenever we encounter a 'I' shift from 'D' so that we always choose greedy
 * i.e the numbers to the left adhere to pattern and will always be smaller and upcoming
 * numbers who are always larger ensure the increase even if we reverse in future.
 */