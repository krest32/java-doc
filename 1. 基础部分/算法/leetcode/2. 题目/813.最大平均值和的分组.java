/*
 * @lc app=leetcode.cn id=813 lang=java
 *
 * [813] 最大平均值和的分组
 */

// @lc code=start
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        // 动态规划
        return extracted(nums, k);

    }

    /**
     * Your runtime beats 78.52 % of java submissions
     * Your memory usage beats 51.41 % of java submissions (38.8 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private double extracted(int[] nums, int k) {
        int len = nums.length;
        double[] ret = new double[len + 1];
        for (int i = 0; i < len; i++) {
            ret[i + 1] = ret[i] + nums[i];
        }
        // dp记录从i-len的区间平均值
        double[] dp = new double[len];
        for (int i = 0; i < len; i++) {
            dp[i] = (ret[len] - ret[i]) / (len - i);
        }

        // 分成最多k个
        for (int n = 0; n < k - 1; n++) {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    // 两段式
                    dp[i] = Math.max(dp[i], (ret[j] - ret[i]) / (j - i) + dp[j]);
                }
            }
        }
        return dp[0];
    }
}// lc code=end
