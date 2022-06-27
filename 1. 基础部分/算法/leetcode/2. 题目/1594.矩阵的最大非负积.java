/*
 * @lc app=leetcode.cn id=1594 lang=java
 *
 * [1594] 矩阵的最大非负积
 */

// @lc code=start
class Solution {
    public int maxProductPath(int[][] grid) {
        final int MOD = 1000000000 + 7;
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxgt = new long[m][n];
        long[][] mingt = new long[m][n];

        maxgt[0][0] = mingt[0][0] = grid[0][0];
        // 求其二维数组的边界乘积值
        for (int i = 1; i < n; i++) {
            maxgt[0][i] = mingt[0][i] = maxgt[0][i - 1] * grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            maxgt[i][0] = mingt[i][0] = maxgt[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxgt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                    mingt[i][j] = Math.min(mingt[i][j - 1], mingt[i - 1][j]) * grid[i][j];
                } else {
                    maxgt[i][j] = Math.min(mingt[i][j - 1], mingt[i - 1][j]) * grid[i][j];
                    mingt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                }
            }
        }
        if (maxgt[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxgt[m - 1][n - 1] % MOD);
        }
    }
}
// @lc code=end
