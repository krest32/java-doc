/*
 * @lc app=leetcode.cn id=1351 lang=java
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
class Solution {
    public int countNegatives(int[][] grid) {
        // 二分查找
        return extracted(grid);

        // 暴力
        // return extracted2(grid);

    }

    /**
     * Your runtime beats 42.68 % of java submissions
     * Your memory usage beats 8.19 % of java submissions (42 MB)
     * 
     * @param grid
     * @return
     */
    private int extracted2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 二分查找
     */
    private int extracted(int[][] grid) {
        int res = 0, m = grid[0].length, n = grid.length;
        int ind = m;
        for (int i = 0; i < n; ++i) {
            if (ind == 0)
                break;
            if (grid[i][ind - 1] >= 0)
                continue;
            int cnt = 0;
            while (ind - 1 >= 0 && grid[i][ind - 1] < 0) {
                --ind;
                ++cnt;
            }
            res += cnt * (n - i);
        }
        return res;
    }
}
// @lc code=end
