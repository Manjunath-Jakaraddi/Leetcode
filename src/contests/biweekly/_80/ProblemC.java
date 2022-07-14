package contests.biweekly._80;

import java.util.*;

public class ProblemC {
    public static void main(String[] args) {
        String s = "9314o85hn6gc0amwqxipx4lgqokxlobgbhkcp6oyamuols1f2w65il0mm4i28omxq2occg7trfm6sx7o5zkoq4po5uzmuet";
        String sub = "kcp6oyamuols1f2w65il0mm4i28omx";
        char[][] mappings = {
                {'o', '0'}
        };
        System.out.println(matchReplacement(s, sub, mappings));
    }

    public static boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] charMappings = new boolean[260][260];
        for (int i = 0; i < mappings.length; i++) {
            charMappings[mappings[i][0]][mappings[i][1]] = true;
        }
        int N = s.length();
        int M = sub.length();
        char[] str = s.toCharArray();
        char[] subStr = sub.toCharArray();
        for (int i = 0; i <= N-M; i++) {
            int ind = 0;
            for (int j = 0; j < M; j++) {
                if (str[i+j] == subStr[j] || charMappings[subStr[j]][str[i+j]]) {
                    ind++;
                }
            }
            if (ind == M) {
                return true;
            }
        }
        return false;
    }

    private static Map<String, Boolean> possibleSubs;
    private static Map<Character, List<Character>> characterMappings;

    public static boolean matchReplacementTLE(String s, String sub, char[][] mappings) {
        characterMappings = new HashMap<>();
        possibleSubs = new HashMap<>();
        int N = s.length(), M = sub.length();
        for (int i = 0; i <= N-M; i++) {
            possibleSubs.put(s.substring(i, i+M), true);
        }
        for (int i = 0; i < mappings.length; i++) {
            if (!characterMappings.containsKey(mappings[i][0])) {
                characterMappings.put(mappings[i][0], new ArrayList<>());
            }
            characterMappings.get(mappings[i][0]).add(mappings[i][1]);
        }
        return solve(sub, 0);
    }

    private static boolean solve(String sub, int pos) {
        if (pos >= sub.length()) return false;
        if (!characterMappings.containsKey(sub.charAt(pos))) {
            return solve(sub, pos+1);
        }
        if (solve(sub, pos+1)) {
            return true;
        }
        char curr = sub.charAt(pos);
        for (int i = 0; i < characterMappings.get(curr).size(); i++) {
            char[] newString = sub.toCharArray();
            newString[pos] = characterMappings.get(curr).get(i);
            if (possibleSubs.containsKey(String.valueOf(newString))) {
                return true;
            }
            if (solve(String.valueOf(newString), pos+1)) {
                return true;
            }
        }
        return false;
    }
}