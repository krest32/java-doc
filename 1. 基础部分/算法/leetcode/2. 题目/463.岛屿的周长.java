/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    int[] dx = { 1, 0, 0, -1 };
    int[] dy = { 0, 1, -1, 0 };

    public int islandPerimeter(int[][] grid) {
        // 广度优先 --> 最优解
        return extracted(grid);

        // 深度有限
        // return extracted2(grid);
    }

    /**
     * Your runtime beats 34.09 % of java submissions
     * Your memory usage beats 37.68 % of java submissions (41.9 MB)
     */
    private int extracted2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                    break;
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;

    }

    /**
     * Your runtime beats 86.02 % of java submissions
     * Your memory usage beats 8.53 % of java submissions (42.4 MB)
     * 
     * @param grid
     * @return
     */
    private int extracted(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        // 遍历每个格子的每条边是否面临边界或者水域，如果是，那么这条边贡献一个单位周长
                        if (newi < 0 || newi >= rows || newj < 0 || newj >= colums
                                || grid[newi][newj] == 0) {
                            cnt += 1;
                        }
                    }
                    res += cnt;
                }
            }
        }
        return res;
    }
}
// @lc code=end
