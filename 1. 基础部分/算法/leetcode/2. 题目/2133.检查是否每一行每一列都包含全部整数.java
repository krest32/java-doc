import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2133 lang=java
 *
 * [2133] 检查是否每一行每一列都包含全部整数
 */

// @lc code=start
class Solution {
    public boolean checkValid(int[][] matrix) {

        // 模拟
        return extracted(matrix);
    }

    private boolean extracted(int[][] matrix) {
        int n = matrix.length;
        int Row = n;
        int Col = n;

        int[] a = new int[n];
        for (int i = 1; i < n + 1; i++) {
            a[i - 1] = i;
        }

        // -------- 行
        for (int[] row : matrix) {
            int[] tmp = new int[n];
            System.arraycopy(row, 0, tmp, 0, n);
            Arrays.sort(tmp);
            for (int i = 0; i < n; i++) {
                if (a[i] != tmp[i]) {
                    return false;
                }
            }
        }

        // -------- 列
        for (int c = 0; c < Col; c++) {
            int[] tmp = new int[Row];
            for (int r = 0; r < Row; r++) {
                tmp[r] = matrix[r][c];
            }
            Arrays.sort(tmp);
            for (int i = 0; i < n; i++) {
                if (a[i] != tmp[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end
