/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        // 基于图的BFS，效率有点低
        // return method(grid);

        // 动态规划
        return method2(grid);
    }

    /**
     * Your runtime beats 51.47 % of java submissions
     * Your memory usage beats 37.65 % of java submissions (42.3 MB)
     * 
     * @param grid
     * @return
     */
    int method2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j][0]: i,j左边连续的1的个数
        // dp[i][j][1]: i,j上边连续的1的个数
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    dp[i][j][0] = 1 + dp[i][j - 1][0];
                    dp[i][j][1] = 1 + dp[i - 1][j][1];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 最短的那条边不一定是合法的边长，如果该边长不合法就需要缩减边长，直到找到合法的
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--) {
                    if (dp[i][j - side + 1][1] >= side && dp[i - side + 1][j][0] >= side) {
                        res = Math.max(res, side);
                        // 更短的就没必要考虑了
                        break;
                    }
                }
            }
        }
        return res * res;
    }

    /**
     * Your runtime beats 5.29 % of java submissions
     * Your memory usage beats 7.06 % of java submissions (42.6 MB)
     * 
     * @param grid
     * @return
     */
    int method(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int colums = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                // 将该点作为正方形的左顶点
                if (grid[i][j] == 1) {
                    // 初始化ans
                    int cur = 1;
                    ans = Math.max(ans, cur);
                    int len = Math.min(rows - i, colums - j);
                    // 去重
                    if (len * len > ans) {
                        for (int k = len - 1; k > 0; k--) {
                            // 如果确定是正方形
                            if (check(grid, i, j, k)) {
                                ans = Math.max(ans, (k + 1) * (k + 1));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    boolean check(int[][] grid, int i, int j, int k) {
        for (int start = 0; start <= k; start++) {
            if (grid[i + start][j] != 1
                    || grid[i][j + start] != 1
                    || grid[i + k][j + start] != 1
                    || grid[i + start][j + k] != 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
