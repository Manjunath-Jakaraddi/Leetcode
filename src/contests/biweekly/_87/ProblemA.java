package contests.biweekly._87;

public class ProblemA {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String start, end;
        if (arriveAlice.compareTo(arriveBob) > 0) {
            start = arriveAlice;
        } else {
            start = arriveBob;
        }
        if (leaveAlice.compareTo(leaveBob) > 0) {
            end = leaveBob;
        } else {
            end = leaveAlice;
        }
        int startMonth = Integer.parseInt(start.substring(0,2));
        int startDate = Integer.parseInt(start.substring(3, 5));
        int endMonth = Integer.parseInt(end.substring(0, 2));
        int endDate = Integer.parseInt(end.substring(3, 5));
        if (startMonth == endMonth) {
            return Math.max(endDate - startDate + 1, 0);
        }
        if (startMonth > endMonth) {
            return 0;
        }
        int res = days[startMonth-1] - startDate + 1;
        for (int m = startMonth; m<endMonth-1; m++) {
            res+=days[m];
        }
        res += endDate;
        return res;
    }
}
