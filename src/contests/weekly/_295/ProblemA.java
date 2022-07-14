package contests.weekly._295;

public class ProblemA {
    public int rearrangeCharacters(String s, String target) {
        int[] freq = new int[26];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            freq[str[i] - 'a']++;
        }
        char[] tar = target.toCharArray();
        int res = Integer.MAX_VALUE;
        int[] dfreq = new int[26];
        for (int i = 0; i < target.length(); i++) {
            dfreq[tar[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (dfreq[i] != 0) {
                res = Math.min(res, freq[i]/dfreq[i]);
            }
        }
        return res;
    }
}
