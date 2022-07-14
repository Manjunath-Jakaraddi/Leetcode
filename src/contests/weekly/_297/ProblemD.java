package contests.weekly._297;

import java.util.HashSet;

public class ProblemD {
    public long distinctNames(String[] ideas) {
        int ans = 0;
        HashSet<Integer>[] count = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            count[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            count[(idea.charAt(0) - 'a')].add(idea.substring(1).hashCode());
        }
        for (int i = 0; i < 26; i++) {
            for (int j = i+1; j < 26; j++) {
                int c1 = 0, c2 = 0;

                for (int c : count[i]) {
                    if (!count[j].contains(c))
                        c1++;
                }

                for (int c : count[j]) {
                    if (!count[i].contains(c)) {
                        c2++;
                    }
                }

                ans += (c1 * c2);
            }
        }
        return ans >> 1;
    }
}

/**
 * TODO
 * Revise combinatorics
 * for given i and given j grouped (i and j being initial characters)
 *  if there are c1 string in j for given suffix in i which do not have same suffix
 *  and there are c2 string in i for given suffix in j which do not have same suffix
 *  then possible combinations that can be formed are c1*c2*2 (*2 if i and j groups are reversed)
 */