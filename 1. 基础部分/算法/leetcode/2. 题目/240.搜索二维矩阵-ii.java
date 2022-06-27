/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 暴力
        // return extracted(matrix, target);

        // 二分查找 变种
        return extracted2(matrix, target);
    }

    /**
     * 129/129 cases passed (5 ms)
     * Your runtime beats 93.78 % of java submissions
     * Your memory usage beats 40.39 % of java submissions (47.3 MB)
     * 
     * @param matrix
     * @param target
     * @return
     */
    private boolean extracted2(int[][] matrix, int target) {
        int rows = matrix.length;
        int colums = matrix[0].length;
        int x = 0;
        int y = colums - 1;
        while (x < rows && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    /**
     * 129/129 cases passed (11 ms)
     * Your runtime beats 9.22 % of java submissions
     * Your memory usage beats 14.65 % of java submissions (47.5 MB)
     * 
     * @param matrix
     * @param target
     * @return
     */
    private boolean extracted(int[][] matrix, int target) {
        int rows = matrix.length;
        int colums = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
