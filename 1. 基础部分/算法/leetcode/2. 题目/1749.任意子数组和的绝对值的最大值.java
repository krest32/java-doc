/*
 * @lc app=leetcode.cn id=1749 lang=java
 *
 * [1749] 任意子数组和的绝对值的最大值
 */

// @lc code=start
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int len = nums.length;
        // 记录到达 i 位置，拥有的最小值和最大值
        int[][] dp = new int[len][2];
        // 初始化记录
        dp[0] = new int[] { nums[0], nums[0] };
        int maxAns = Math.abs(nums[0]);
        for (int i = 1; i < len; i++) {
            // 记录一个最小值
            dp[i][0] = Math.min(nums[i], dp[i - 1][0] + nums[i]);
            // 记录一个最大值
            dp[i][1] = Math.max(nums[i], dp[i - 1][1] + nums[i]);
            maxAns = Math.max(maxAns, Math.abs(dp[i][0]));
            maxAns = Math.max(maxAns, Math.abs(dp[i][1]));
        }
        return maxAns;
    }
}
// @lc code=end
