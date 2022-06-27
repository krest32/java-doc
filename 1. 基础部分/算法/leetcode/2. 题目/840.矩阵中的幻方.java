/*
 * @lc app=leetcode.cn id=840 lang=java
 *
 * [840] 矩阵中的幻方
 */

// @lc code=start
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, colums = grid[0].length;
        int ans = 0;
        for (int r = 0; r < rows - 2; ++r)
            for (int c = 0; c < colums - 2; ++c) {
                // 中心需要是5，才能成为合理矩阵
                if (grid[r + 1][c + 1] != 5)
                    continue; // optional skip
                if (magic(grid[r][c], grid[r][c + 1], grid[r][c + 2],
                        grid[r + 1][c], grid[r + 1][c + 1], grid[r + 1][c + 2],
                        grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2]))
                    ans++;
            }

        return ans;
    }

    public boolean magic(int... vals) {
        // 统计每个数字的出现频率
        int[] count = new int[16];
        for (int v : vals)
            count[v]++;
        // 判断9个数字中，不能由重复的数字
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}
// @lc code=end
