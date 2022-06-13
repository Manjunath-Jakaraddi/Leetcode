package contests.weekly._293;

import java.util.*;

public class ProblemA {

    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> st = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            char[] charArray = words[i].toCharArray();
            Arrays.sort(charArray);
            String str = new String(charArray);
            if (!st.contains(str)) {
                res.add(words[i]);
            }
            st.add(str);
        }
        return res;
    }
}
