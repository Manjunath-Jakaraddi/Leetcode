package random.assessment.faang;

public class CityMoney {
    public static void main(String[] args) {
        int[] cityA = new int[] {10, 1, 20, 40};
        int[] cityB = new int[] {5, 4, 100, 30};


        int N = cityA.length;
        int[][] dp = new int[N+1][2];
        dp[1][0] = cityA[0];
        dp[1][1] = cityB[0];
        for (int i=2; i<=N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1]) + cityA[i-1];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]) + cityB[i-1];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
