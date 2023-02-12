package contests.biweekly._87;

import java.util.Arrays;

public class ProblemB {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int pInd = 0, tInd = 0;
        int P = players.length, T = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int res = 0;
        while (pInd < P && tInd < T) {
            if (players[pInd] <= trainers[tInd]) {
                pInd++;
                tInd++;
                res++;
            } else {
                tInd++;
            }
        }
        return res;
    }
}
