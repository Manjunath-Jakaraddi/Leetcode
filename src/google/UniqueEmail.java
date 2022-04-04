package google;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Link: https://leetcode.com/explore/featured/card/google/67/sql-2/3044/
public class UniqueEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] emails = new String[2];
        emails[0] = sc.nextLine();
        emails[1] = sc.nextLine();
        solve(emails);
    }

    public static int solve(String[] emails) {
        Set<String> st = new HashSet<>();
        for(String email : emails) {
            boolean foundAt = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< email.length(); i++) {
                if (email.charAt(i) == '@') {
                    foundAt = true;
                    sb.append(email.charAt(i));
                }
                else if (!foundAt ) {
                    if (email.charAt(i) == '+') {
                        while (email.charAt(i+1) != '@') i++;
                    } else if (email.charAt(i) != '.') {
                        sb.append(email.charAt(i));
                    }

                } else {
                    sb.append(email.charAt(i));
                }
            }
            st.add(sb.toString());
        }
        st.forEach(System.out::println);
        return st.size();
    }
}

/**
 * Too many conditions handling checked
 * along with the ordering of the conditions and state maintainence
 */