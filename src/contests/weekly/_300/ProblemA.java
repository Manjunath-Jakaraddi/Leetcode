package contests.weekly._300;

public class ProblemA {
    public String decodeMessage(String key, String message) {
        int mask = 0;
        char[] mappings = new char[26];
        int ind = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch < 'a' || ch > 'z') continue;
            if ((mask & (1 << (ch - 'a'))) != 0) continue;
            mappings[(ch - 'a')] = (char)(ind + 'a');
            mask |= 1 << (ch - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(mappings[(ch - 'a')]);
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
