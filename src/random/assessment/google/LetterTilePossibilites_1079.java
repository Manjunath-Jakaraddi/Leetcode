package random.assessment.google;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilites_1079 {
    Set<String> set = new HashSet<>();
    public int numTilePossibilitiesBackTrackMine(String tiles) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }
        solve(sb, freq);
        return set.size();
    }

    void solve(StringBuilder sb, int[] freq) {
        boolean allZero = true;
        for (int i=0; i<26; i++) {
            if (freq[i] > 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            return;
        }

        for (int i=0; i<26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                char addChar = (char) (i + 'A');
                sb.append(addChar);
                set.add(sb.toString());
                solve(sb, freq);
                freq[i]++;
                sb.setLength(sb.length() - 1);
            }
        }
    }

    /**
     * Observation:
     * 1. We need to generate all permutation for each combination
     * 2. The number of permutations for each combination can be calculated in constant time.
     *      Using the formula, n! / (freq[1]! * freq[2]! * .. * freq[i]!)
     *      where freq[i] -> is the character freq in a particular combination
     * 3. And generating combination is through inclusion exclusion principle, after sorting
     */
}
