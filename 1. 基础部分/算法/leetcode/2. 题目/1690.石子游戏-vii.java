import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1690 lang=java
 *
 * [1690] 石子游戏 VII
 */

// @lc code=start
class Solution {
    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        int[] dp = new int[len];
        int[] sums = new int[len];
        System.arraycopy(stones, 0, sums, 0, len);
        // 其实最后反而有点像是滑动窗口+动态规划
        for (int max = len - 1; max > 0; max--) {
            for (int x = 0; x < max; x++) {
                int y = x + len - max;
                sums[x] = sums[x] + stones[y];
                int gx = sums[x] - stones[x]; // 移除左边
                int gy = sums[x] - stones[y]; // 移除右边
                dp[x] = Math.max(gx - dp[x + 1], gy - dp[x]); // 动态规划递推式
            }
        }
        return dp[0];
    }
}
// @lc code=end
