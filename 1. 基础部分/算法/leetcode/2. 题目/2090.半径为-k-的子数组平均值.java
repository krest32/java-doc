/*
 * @lc app=leetcode.cn id=2090 lang=java
 *
 * [2090] 半径为 k 的子数组平均值
 */

// @lc code=start
class Solution {
    public int[] getAverages(int[] nums, int k) {
        // 需要注意边界问题
        // 贪心 --> 存在优化的空间
        return extracted(nums, k);
    }

    /**
     * Your runtime beats 35.33 % of java submissions
     * Your memory usage beats 95.21 % of java submissions (53.6 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private int[] extracted(int[] nums, int k) {
        int len = nums.length;
        long[] dp = new long[len];
        // 求取累加和
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        int[] ans = new int[len];
        int idx = 0;
        int num = 2 * k + 1;
        while (idx < len) {
            int left = idx - k;
            int right = idx + k;
            if (left < 0 || right >= len) {
                ans[idx] = -1;
            } else {
                // 需要注意边界问题
                long avg = (dp[right] - dp[left] + nums[left]) / num;
                ans[idx] = (int) avg;
            }
            idx++;
        }
        return ans;
    }
}
// @lc code=end
