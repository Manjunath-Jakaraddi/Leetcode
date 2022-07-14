package contests.weekly._298

import kotlin.math.max

fun sellingWood(N: Int, M: Int, prices: Array<IntArray>): Long {
    val dp = Array(N) { LongArray(M) }
    for ((r, c, p) in prices) {
        dp[r][c] = p.toLong()
    }
    for (row in 1 until N) {
        for (col in 1 until M) {
            for (i in 1..col/2) {
                dp[row][col] = max(dp[row][col], dp[row][i] + dp[row][col-i])
            }
            for (i in 1..row/2) {
                dp[row][col] = max(dp[row][col], dp[i][col] + dp[row-i][col])
            }
        }
    }
    return dp[N][M];
}