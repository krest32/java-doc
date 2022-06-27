/**
 * @lc app=leetcode.cn id=62 lang=java
 *
 *     [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // 动态方程：
        // dp[i][j] = dp[i][j-1] + dp[i-1][j]
        int[][] road = new int[m][n];
        for (int i = 0; i < m; i++) {
            road[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            road[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                road[i][j] = road[i - 1][j] + road[i][j - 1];
            }
        }
        return road[m - 1][n - 1];
    }
}
// @lc code=end
