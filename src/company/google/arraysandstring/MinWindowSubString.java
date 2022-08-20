package company.google.arraysandstring;

public class MinWindowSubString {
    public String minWindow(String s1, String t1) {
        int N = s1.length(), M = t1.length();
        char[] s = s1.toCharArray(), t = t1.toCharArray();

        int[] tMap = new int[256], sMap = new int[256];
        for (char ch : t) {
            tMap[ch]++;
        }
        int l = 0, r = 1, rLen = Integer.MAX_VALUE;
        String res = "";
        if (tMap[s[0]] > 0) sMap[s[0]]++;
        while (l < r) {
            // Terminates when l == r which happens when we keep increasing l at last while loop
            while (r < N && !checkEqual(tMap, sMap)) {
                if (tMap[s[r]] > 0) {
                    sMap[s[r]]++;
                }
                r++;
            }
            if (checkEqual(tMap, sMap)) {
                if (rLen > (r - l)) {
                    rLen = r - l;
                    res = s1.substring(l, r);
                }
            }
            boolean removed = false;
            while (l < r) {
                if (removed && tMap[s[l]] > 0) {
                    break;
                }
                if (checkEqual(tMap, sMap)) {
                    if (rLen > (r - l)) {
                        rLen = r - l;
                        res = s1.substring(l, r);
                    }
                }
                if (tMap[s[l]] > 0) {
                    sMap[s[l]]--;
                    removed = true;
                }
                l++;
            }
        }
        return res;
    }

    private boolean checkEqual(int[] tMap, int[] sMap) {
        for (int i=0; i<256; i++) {
            if (sMap[i] < tMap[i]) return false;
        }
        return true;
    }
}
