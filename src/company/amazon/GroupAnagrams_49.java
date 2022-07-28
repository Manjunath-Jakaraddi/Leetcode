package company.amazon;

import java.util.*;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mmap = new HashMap<>();
        for(String str : strs) {
            String s = sortString(str);
            if(!mmap.containsKey(s)) {
                mmap.put(s, new ArrayList<>());
            }
            mmap.get(s).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> item : mmap.values()) {
            res.add(item);
        }
        return res;
    }

    String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
