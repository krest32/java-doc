import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2110 lang=java
 *
 * [2110] 股票平滑下跌阶段的数目
 */

// @lc code=start
class Solution {
    public long getDescentPeriods(int[] prices) {
        // 动态规划
        // return extracted(prices);

        // 1
        return test(prices);
    }

    private long test(int[] prices) {
        int len = prices.length;
        long[] dp = new long[len];
        Arrays.fill(dp, 1);
        long ans = dp[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] + 1 == prices[i - 1]) {
                dp[i] += dp[i - 1];
            }
            ans += dp[i];
        }
        return ans;
    }

    private long extracted(int[] prices) {
        int len = prices.length;
        // 以i为终点的平滑下跌的个数
        long[] dp = new long[len + 1];
        dp[0] = 1;
        long ans = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            // 满足平滑下架的定义
            int num = prices[i - 1] - prices[i];
            if (num == 1) {
                dp[i] += dp[i - 1];
            }
            ans += dp[i];
        }
        return ans;
    }
}
// @lc code=end
