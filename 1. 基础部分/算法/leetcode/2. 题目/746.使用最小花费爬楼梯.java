/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {

        // 动态方程：爬到下一个台阶的最小花费,可以是跳1阶，也可以是跳2阶
        // dp[i] = Math.min(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1]);

        return extracted(cost);

    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 30.29 % of java submissions (41 MB)
     * 
     * @param cost
     * @return
     */
    private int extracted(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 起始可以选择爬上1级或者2级台阶
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            // 计算爬到下级台阶的最小花费
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }
}
// @lc code=end
