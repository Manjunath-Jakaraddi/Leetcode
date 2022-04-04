package topinterview.strings;

//Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/887/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String search = strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<search.length(); i++) {
            int count = 0;
            for(String str : strs) {
                if(i < str.length() && search.charAt(i) == str.charAt(i)) {
                    count++;
                }
            }
            if(count != strs.length) {
                return sb.toString();
            }
            sb.append(search.charAt(i));
        }
        return sb.toString();
    }
}
