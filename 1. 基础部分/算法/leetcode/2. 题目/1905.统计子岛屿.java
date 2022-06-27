/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
class Solution {
    int[][] direcs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        return extracted(grid1, grid2);
    }

    /**
     * Your runtime beats 34.21 % of java submissions
     * Your memory usage beats 24.01 % of java submissions (72.7 MB)
     * 
     * @param grid1
     * @param grid2
     * @return
     */
    private int extracted(int[][] grid1, int[][] grid2) {
        int rows = grid2.length;
        int colums = grid2[0].length;
        int ret = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                // 如果滿足子岛屿
                if (grid2[i][j] == 1 && check(grid1, grid2, i, j)) {
                    ret++;
                }
            }
        }
        return ret;
    }

    private boolean check(int[][] grid1, int[][] grid2, int i, int j) {
        grid2[i][j] = 0;
        int rows = grid2.length;
        int colums = grid2[0].length;
        boolean flag = true;
        if (grid1[i][j] != 1) {
            flag = false;
        }
        for (int[] direc : direcs) {
            int newi = i + direc[0];
            int newj = j + direc[1];
            if (newi >= 0
                    && newj >= 0
                    && newi < rows
                    && newj < colums
                    && grid2[newi][newj] == 1) {
                if (!check(grid1, grid2, newi, newj)) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}
// @lc code=end
