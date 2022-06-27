/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 暴力解法
        // return extracted2(prices);

        // 两种动态规划速度类似

        // 动态规划一
        return extracted(prices);

        // 动态规划二
        // return extracted3(prices);

    }

    /**
     * 动态规划二
     * 执行用时：4 ms, 在所有 Java 提交中击败了24.80%的用户
     * 内存消耗：52.2 MB, 在所有 Java 提交中击败了63.00%的用户
     * 
     * @param prices
     * @return
     */
    private int extracted3(int[] prices) {
        // dp[i] = Mathmax(dp[i-1]+(prices[i]-prices[i-1]), 0)
        int len = prices.length;
        // 求取每个位置上的最大值利润
        int[] dp = new int[len];
        dp[0] = 0;
        int ans = 0;

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            dp[i] = Math.max(dp[i - 1] + diff, 0);
            // 通过比较得出最大的利润值
            ans = Math.max(dp[i], ans);
        }
        return ans;

    }

    /**
     * 暴力解法 -> 超时
     * 
     * @param prices
     * @return
     */
    private int extracted2(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    /**
     * 
     * 动态规划
     * 
     * Your runtime beats 71.03 % of java submissions
     * Your memory usage beats 21.97 % of java submissions (57.6 MB)
     * 
     * @param prices
     * @return
     */
    private int extracted(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        // 遍历所有价格
        for (int i = 1; i < prices.length; i++) {
            // 随时获取最小值
            if (minPrice > prices[i]) {
                minPrice = prices[i];
                // 动态获取最大利润
            } else if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
// @lc code=end
