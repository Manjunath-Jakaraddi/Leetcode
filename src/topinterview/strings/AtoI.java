package topinterview.strings;

import java.util.Scanner;

//Link:= https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/884/
public class AtoI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(myAtoi(sc.nextLine()));
    }
    public static int myAtoi(String s) {
        if (s.length() == 0) return 0;
        int currInd = 0;
        while(currInd < s.length() && s.charAt(currInd) == ' ') currInd++;
        boolean isNeg = false;
        if(currInd < s.length() && s.charAt(currInd) == '-') {
            isNeg = true;
            currInd++;
        } else if (currInd < s.length() && s.charAt(currInd) == '+') {
            currInd++;
        }
        if (s.length() == currInd ||
                !(s.charAt(currInd) >= '0' && s.charAt(currInd) <= '9')) return 0;
        long res = 0;
        while(currInd < s.length() && s.charAt(currInd) >= '0' && s.charAt(currInd) <= '9') {
            res = res * 10;
            int num = (s.charAt(currInd) - '0');
            res = (res + num);
            if (isNeg && res - 1 >= Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!isNeg && res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            currInd++;
        }
        if (isNeg) {
            return (int) -res;
        }
        return (int) res;
    }
}
