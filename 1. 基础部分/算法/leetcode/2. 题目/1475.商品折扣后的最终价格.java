/*
 * @lc app=leetcode.cn id=1475 lang=java
 *
 * [1475] 商品折扣后的最终价格
 */

// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        // 模拟
        return extracted(prices);
    }

    /**
     * 103/103 cases passed (1 ms)
     * Your runtime beats 98.97 % of java submissions
     * Your memory usage beats 68.13 % of java submissions (41.3 MB)
     * 
     * @param prices
     * @return
     */
    private int[] extracted(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int price = prices[i];
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    price = prices[i] - prices[j];
                    break;
                }
            }
            ans[i] = price;
        }
        return ans;
    }
}
// @lc code=end
