/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int colums = matrix[0].length;
        boolean[] rowflag = new boolean[rows];
        boolean[] columflag = new boolean[colums];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (matrix[i][j] == 0) {
                    rowflag[i] = true;
                    columflag[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (rowflag[i] == true || columflag[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end
