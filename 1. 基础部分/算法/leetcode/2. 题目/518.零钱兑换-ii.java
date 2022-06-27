/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // 动态规划--> 完全背包
        // return extracted(amount, coins);

        // 1
        return test(amount, coins);

    }

    private int test(int amount, int[] coins) {
        // dp[i] 记录金额为 i 时， coin 的组合数量
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }

/**
28/28 cases passed (3 ms)
Your runtime beats 47.19 % of java submissions
Your memory usage beats 36.68 % of java submissions (39.1 MB)
 */
    private int extracted(int amount, int[] coins) {
        // dp 数组记录达成该额度最小的硬币数量 dp[i] = dp[i] + dp[i-coin];
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 计算的是组合数
        for (int coin : coins) {
            // 从最小值coin开始
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        // 计算的是排列数--> 不符合题意
        // 背包容量的每一个值，如：经过 1 和 5 的计算，包含了{1, 5} 和 {5, 1}两种情况
        // for (int j = 0; j <= amount; j++) { // 遍历背包容量
        // for (int i = 0; i < coins.length; i++) { // 遍历物品
        // if (j - coins[i] >= 0)
        // dp[j] += dp[j - coins[i]];
        // }
        // }
        return dp[amount];
    }
}
// @lc code=end
