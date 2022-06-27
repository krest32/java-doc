/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                ans = Math.max(ans, dfs(grid,i,j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int curi, int curj) {
        if(curi<0 || curj<0 || curi>=grid.length || curj>=grid[0].length || grid[curi][curj]!=1){
            return 0;
        }
        grid[curi][curj] = 0;
        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};
        int ans = 1;
        for(int index = 0; index<4; index++){
            int newi = curi+di[index];
            int newj = curj+dj[index];
            ans += dfs(grid, newi, newj);
        }
        return ans;
    }

}
// @lc code=end

