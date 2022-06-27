/**
 * @lc app=leetcode.cn id=122 lang=java
 *
 *     [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 贪心
        // return extracted(prices);

        // 动态规划
        return extracted2(prices);
    }

    /**
     * Your runtime beats 23.78 % of java submissions
     * Your memory usage beats 8.89 % of java submissions (41.5 MB)
     * 
     * @param prices
     * @return
     */
    private int extracted2(int[] prices) {
        int n = prices.length;
        // 创建二维数组存储状态
        int[][] dp = new int[n][2];
        // 初始状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // 第 i 天，没有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第 i 天，持有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0]; // 卖出股票收益高于持有股票收益，因此取[0]
    }

    private int extracted(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum = sum + (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }
}
// @lc code=end
