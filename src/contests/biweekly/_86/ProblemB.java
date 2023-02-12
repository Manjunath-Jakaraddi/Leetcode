package contests.biweekly._86;

public class ProblemB {

    public boolean isStrictlyPalindromic(int n) {
        return false;
    }

    public boolean isStrictlyPalindromicMine(int n) {
        for (int i=2; i<n-1; i++) {
            boolean isPalindrome = computeBase(n, i);
            if (!isPalindrome) {
                return false;
            }
        }
        return true;
    }

    boolean computeBase(int n, int b) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int x = n%b;
            char ch = (char) (x + '0');
            sb.append(ch);
            n/=b;
        }
        String str = sb.toString();
        String rev = sb.reverse().toString();
        return str.equals(rev);
    }
}

/**
 * For 4 = 100 (in binary) is not palindromic 2
 * so for any number greater than 2 base also it'll not be palindromic
 * hence just return false :)
 */
