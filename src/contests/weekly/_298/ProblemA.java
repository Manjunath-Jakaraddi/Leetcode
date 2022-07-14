package contests.weekly._298;

public class ProblemA {
    public static void main(String[] args) {
        System.out.println(greatestLetter("AbCdEfGhIjK"));
    }
    public static String greatestLetter(String s) {
        int lower = 0, upper = 0;
        char ans = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                if (((upper & (1 << (c-'a'))) != 0)) {
                    if (Character.toLowerCase(c) > Character.toLowerCase(ans)) {
                        ans = c;
                    }
                } else {
                    lower |= (1 << (c-'a'));
                }
            } else {
                if (((lower & (1 << (c-'a'))) != 0)) {
                    if (Character.toLowerCase(c) > Character.toLowerCase(ans)) {
                        ans = c;
                    }
                } else {
                    upper |= (1 << (c-'a'));
                }
            }
        }
        return ans == 0 ? "" : String.valueOf(Character.toUpperCase(ans));
    }
}
