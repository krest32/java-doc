import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1727 lang=java
 *
 * [1727] 重新排列后的最大子矩阵
 */

// @lc code=start
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        // 动态规划
        // return extracted(matrix);

        // 先计算matrix每一列的连续1的个数，
        // 如果为 1，matirx(i, j) = matrix(i-1, j)+1
        // 对于每一行进行排序，计算最大子矩阵的面积
        return extracted2(matrix);
    }

    private int extracted2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                if (i > 0) {
                    if (matrix[i][j] == 1)
                        matrix[i][j] = matrix[i - 1][j] + 1;
                }

            }
        }

        // 对最后一行进行排序
        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    int area = (n - j) * matrix[i][j];
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }

    private int extracted(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int r = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == 1)
                    matrix[r][c] += matrix[r - 1][c];
            }
        }
        int ans = 0;
        for (int r = 0; r < row; r++) {
            Arrays.sort(matrix[r]);
            for (int c = col - 1, w = 1; c >= 0; c--, w++) {
                int area = w * matrix[r][c];
                ans = Math.max(area, ans);
            }
        }
        return ans;
    }
}
// @lc code=end
