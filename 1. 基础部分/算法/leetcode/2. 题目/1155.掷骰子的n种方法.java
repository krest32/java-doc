/*
 * @lc app=leetcode.cn id=1155 lang=java
 *
 * [1155] 掷骰子的N种方法
 */

// @lc code=start
class Solution {

    int mod = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int m, int t) {
        // 代表n个骰子，总和为t的总数
        int[][] f = new int[n + 1][t + 1];
        f[0][0] = 1;
        // 枚举物品组（每个骰子）
        for (int i = 1; i <= n; i++) {
            // 枚举背包容量（所掷得的总点数）
            for (int j = 0; j <= t; j++) {
                // 枚举决策（当前骰子所掷得的点数）
                for (int k = 1; k <= m; k++) {
                    if (j >= k) {
                        // 一个累加的和
                        f[i][j] = (f[i][j] + f[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return f[n][t];
    }
}
// @lc code=end
