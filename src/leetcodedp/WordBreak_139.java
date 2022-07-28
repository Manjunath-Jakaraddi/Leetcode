package leetcodedp;

import java.util.List;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean[] dp = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (String word : wordDict) {
                if (i >= word.length() - 1 && (i == word.length() - 1 || dp[i - word.length()])) {
                    if(s.substring(i - word.length() + 1, i + 1).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[N-1];
    }

}

/**
 * TODO: Try WordBreak II https://leetcode.com/problems/word-break-ii/
 */