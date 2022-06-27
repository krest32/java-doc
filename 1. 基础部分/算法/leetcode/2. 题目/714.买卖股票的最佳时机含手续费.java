

/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 动态规划
        // return extracted(prices, fee);

        // 1
        return test(prices, fee);

    }

    private int test(int[] prices, int fee) {
        int len = prices.length;
        int[] dp = new int[2];
        // dp[0]表示不持有可获得的最大利润
        // dp[1]表示持有可获得的最大利润
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], temp - prices[i]);
        }
        return dp[0];
    }

    /**
     * Your runtime beats 63.57 % of java submissions
     * Your memory usage beats 11.28 % of java submissions (49.8 MB)
     * 
     * @param prices
     * @param fee
     * @return
     */
    private int extracted(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];
        // 0 代表卖出，1代表买入
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }
        return dp[0];
    }
}
// @lc code=end
