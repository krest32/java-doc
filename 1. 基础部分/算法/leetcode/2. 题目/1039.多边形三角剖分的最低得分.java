import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1039 lang=java
 *
 * [1039] 多边形三角剖分的最低得分
 */

// @lc code=start
class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], (k - i <= 1 ? 0 : dp[i][k]) + (j - k <= 1 ? 0 : dp[k][j])
                            + values[i] * values[k] * values[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
// @lc code=end
