package company.google.arraysandstring;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReadNCharactersGivenRead4 {
    Deque<Character> prev = new ArrayDeque<>();
    public int read(char[] buf, int n) {

        int curr = 0, bufInd = 0;
        // copy previous
        int prevSize = prev.size();
        for (int i=0; i<Math.min(prevSize, n); i++) {
            buf[bufInd++] = prev.pollFirst();
        }

        // keep copying until reached
        while (n - bufInd >= 4) {
            char[] buf4 = new char[4];
            int read4Len = read4(buf4);
            for(int i=0; i<read4Len; i++)   buf[bufInd++] = buf4[i];
            if (read4Len < 4) {
                return bufInd;
            }
        }
        if (n - bufInd == 0) {
            return bufInd;
        }
        int remReadLen = n - bufInd;
        char[] buf4 = new char[4];
        int read4Len = read4(buf4);
        for (int i=0; i<Math.min(read4Len, remReadLen); i++) {
            buf[bufInd++] = buf4[i];
        }
        // if extra fetched store for next
        if (read4Len > remReadLen) {
            int prevLen = read4Len - remReadLen;
            for (int i=0; i<prevLen; i++) {
                prev.add(buf4[remReadLen+i]);
            }
        }
        return bufInd;
    }

    private int read4(char[] buf4) {
        buf4 = "ABCD".toCharArray();
        return 4;
    }


    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int readShort(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr == buffCnt) buffPtr = 0;
        }
        return ptr;
    }

    /**
     * Track wrt the read4 buffer using two pointers
     * 1. the buffPtr points to the next character that needs to be processed
     * 2. the buffCnt the total count currently read
     * parallel integrate this with reading n characters.
     */
}
