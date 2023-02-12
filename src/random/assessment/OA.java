package random.assessment;

public class OA {
    static int N = 4;
    static int[] cost = new int[] {1, 2, 3, 2};
    static int[] time = new int[] {1, 2, 3, 2};
    static int[][] memo;
    public static void main(String[] args) {
        int N = cost.length;
        memo = new int[N][N*1000];
        System.out.println(solve(0, 0));
    }
    // t <= 0 -> paid server is free and must be used
    // t > 0 -> paid server is occupied and free server can be used
    static int solve(int i, int t) {
        if (i == cost.length && t >= 0) {
            return 0;
        }
        if (i == cost.length) {
            return (int) 1e9+5;
        }
        // if paid server is free have to pick it
        if (t <= 0) {
            return cost[i] + solve(i + 1, t + time[i]);
        }
        // if paid server is occupied
        // then have to pick free server
        // or wait and schedule on paid server
        return Math.min(
                cost[i] + solve(i+1, t + time[i]),
                solve(i+1, t-1)
        );
    }
}
