/*
 * @lc app=leetcode.cn id=1504 lang=java
 *
 * [1504] 统计全 1 子矩形
 */

// @lc code=start
class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] row = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从上到下依次遍历
                if (j == 0) {
                    row[i][j] = mat[i][j];
                    // 统计竖着的矩形数量
                } else if (mat[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int col = row[i][j];
                if (col != 0) {
                    // 统计以其作为右下角时，有多少个元素全部都是 1 的子矩形
                    for (int k = i; k >= 0; k--) {
                        col = Math.min(col, row[k][j]);
                        ans += col;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
