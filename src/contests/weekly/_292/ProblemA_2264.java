package contests.weekly._292;

public class ProblemA_2264 {
    public String largestGoodInteger(String num) {
        String res = "";
        for(int i=0; i<=num.length()-3; i++) {
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                if (res.length() == 0 || (num.charAt(i) > res.charAt(0))) {
                    res = num.substring(i, i+3);
                }
            }
        }
        return res;
    }
}
