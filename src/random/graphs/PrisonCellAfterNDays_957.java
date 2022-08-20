package random.graphs;

import java.util.HashMap;
import java.util.Map;

public class PrisonCellAfterNDays_957 {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, Integer> mmap = new HashMap<>();
        Map<Integer, Boolean> vis = new HashMap<>();
        int C = cells.length;
        int day = -1;

        for (int i=0; i<256; i++) {
            performOperation(cells, C);
            int mask = cellsToMask(cells);
            if (vis.containsKey(mask)) {
                break;
            }
            day++;
            mmap.put(day, mask);
            vis.put(mask, true);
        }

        int cycleLen = mmap.size();
        n = ((n-1) % cycleLen);
        int resMask = mmap.get(n);
        int[] res = new int[C];
        for (int i=C-1; i>=0; i--) {
            if ((resMask & 1) != 0) {
                res[i] = 1;
            }
            resMask >>= 1;
        }
        return res;
    }

    void performOperation(int[] cells, int C) {

        int[] res = new int[C];
        for (int i=1; i<C-1; i++) {
            if (cells[i-1] == cells[i+1]) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        for (int i = 0; i<C; i++) {
            cells[i] = res[i];
        }
    }

    int cellsToMask(int[] cells) {
        int mask = 0;
        for (int cell : cells) {
            mask <<= 1;
            mask |= cell;
        }
        return mask;
    }

    public int[] prisonAfterNDaysOpt(int[] cells, int n) {
        Map<Integer, Integer> mmap = new HashMap<>();
        Map<Integer, Boolean> vis = new HashMap<>();
        int C = cells.length;
        int day = -1;
        int currMask = cellsToMaskOpt(cells), nextMask = 0;
        for (int i=0; i<256; i++) {
            nextMask = performOperationOpt(currMask);
            if (vis.containsKey(nextMask)) {
                break;
            }
            day++;
            mmap.put(day, nextMask);
            vis.put(nextMask, true);
            currMask = nextMask;
        }

        int cycleLen = mmap.size();
        n = ((n-1) % cycleLen);
        int resMask = mmap.get(n);
        int[] res = new int[C];
        for (int i=C-1; i>=0; i--) {
            if ((resMask & 1) != 0) {
                res[i] = 1;
            }
            resMask >>= 1;
        }
        return res;
    }

    int performOperationOpt(int mask) {
        mask = ~ ((mask << 1) ^ (mask >> 1));
        // setting the first and last bits to zero
        mask &= 0x7e;
        return mask;
    }

    int cellsToMaskOpt(int[] cells) {
        int mask = 0;
        for (int cell : cells) {
            mask <<= 1;
            mask |= cell;
        }
        return mask;
    }
}

/**
 * Good approach
 * First you tried brute force but observed that the max number of states that are
 * possible before the cycle repeats is 256 and then when cycle is found we can
 * reduce the n and compute it more quickly.
 *
 * But you were using string to store the each day's unique state instead you could've
 * made it faster using mask
 *
 * Last Optimization :- As we are using mask to store state the next state can also be
 * computed using the mask itself by left shifting and right shifting then XOR ing and taking the
 * negation of that.
 */
