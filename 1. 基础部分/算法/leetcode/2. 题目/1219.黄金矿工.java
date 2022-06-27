/*
 * @lc app=leetcode.cn id=1219 lang=java
 *
 * [1219] 黄金矿工
 */

// @lc code=start
class Solution {
    int[][] g;
    boolean[][] vis;
    int m, n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int getMaximumGold(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    vis[i][j] = true;
                    ans = Math.max(ans, dfs(i, j));
                    vis[i][j] = false;
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j) {
        int ans = g[i][j];
        for (int[] dirc : dirs) {
            int newi = i + dirc[0];
            int newj = j + dirc[1];
            if (newi >= m || newi < 0 || newj < 0 || newj >= n
                    || g[newi][newj] == 0 || vis[newi][newj]) {
                continue;
            }
            vis[newi][newj] = true;
            ans = Math.max(ans, g[i][j] + dfs(newi, newj));
            vis[newi][newj] = false;
        }
        return ans;
    }
}
// @lc code=end
