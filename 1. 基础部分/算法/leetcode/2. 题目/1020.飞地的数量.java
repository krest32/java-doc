/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] grid) {
        // 矩阵遍历的经典使用
        return extracted(grid);
    }

    /**
     * Your runtime beats 40.6 % of java submissions
     * Your memory usage beats 5.93 % of java submissions (49.5 MB)
     * 
     * @param grid
     * @return
     */
    private int extracted(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        // 先将边缘所有的相邻陆地职位0
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                change(grid, i, 0);
            }
            if (grid[i][colums - 1] == 1) {
                change(grid, i, colums - 1);
            }
        }
        // 去掉边界的飞地
        for (int j = 0; j < colums; j++) {
            if (grid[0][j] == 1) {
                change(grid, 0, j);
            }
            if (grid[rows - 1][j] == 1) {
                change(grid, rows - 1, j);
            }
        }

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (grid[i][j] == 1) {
                    ans += count(grid, i, j);
                }
            }
        }
        return ans;
    }
    
    private int count(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        } else {
            grid[i][j] = 0;
            int sum = 1;
            sum += count(grid, i + 1, j);
            sum += count(grid, i - 1, j);
            sum += count(grid, i, j + 1);
            sum += count(grid, i, j - 1);
            return sum;
        }

    }

    private void change(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || grid[i][j] == 0) {
            return;
        } else {
            grid[i][j] = 0;
            change(grid, i + 1, j);
            change(grid, i - 1, j);
            change(grid, i, j + 1);
            change(grid, i, j - 1);
        }
    }
}
// @lc code=end
