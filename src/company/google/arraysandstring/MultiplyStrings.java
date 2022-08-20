package company.google.arraysandstring;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int N1 = num1.length(), N2 = num2.length();
        StringBuilder[] sb = new StringBuilder[N1];
        for (int i=0; i<N1; i++) {
            sb[i] = new StringBuilder();
        }
        char[] n1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] n2 = new StringBuilder(num2).reverse().toString().toCharArray();
        for (int i = 0; i < N1; i++) {
            int carry = 0;
            for (int k = 0; k < i; k++) {
                sb[i].append('0');
            }
            for (int j = 0; j < N2; j++) {
                int a = n1[i] - '0', b = n2[j] - '0';
                int product = (a * b) + carry;
                carry = product / 10;
                product = product % 10;
                char ele = (char) (product + '0');
                sb[i].append(ele);
            }
            if (carry != 0) {
                char ele = (char) (carry + '0');
                sb[i].append(ele);
            }
        }
        int mxLen = 0;
        for (StringBuilder s : sb) {
            mxLen = Math.max(mxLen, s.length());
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < mxLen; i++) {
            int sum = carry;
            for (int j=0; j<N1; j++) {
                if (sb[j].length() > i) {
                    int ele = (sb[j].charAt(i) - '0');
                    sum += ele;
                }
            }
            carry = sum / 10;
            sum = sum % 10;
            char ele = (char) (sum + '0');
            res.append(ele);
        }
        if (carry != 0) {
            char ele = (char) (carry + '0');
            res.append(ele);
        }
        String r = res.reverse().toString();
        res = new StringBuilder();
        int ind = 0;
        while (ind < r.length() - 1 && r.charAt(ind) == '0')    ind++;
        for (int z = ind; z < r.length(); z++) {
            res.append(r.charAt(z));
        }
        return res.toString();
    }
}
