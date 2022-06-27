import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        // 动态规划 -- 01 背包
        // dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
        // return extracted(nums);

        // 1
        return test(nums);

    }

    private boolean test(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        int len = nums.length;
        int half = sum / 2;
        boolean[][] dp = new boolean[len + 1][half + 1];
        for (int i = 1; i <= len; i++) {
            int cur = nums[i - 1];
            for (int j = 0; j <= half; j++) {
                dp[i][j] = dp[i - 1][j];
                if (cur == j)
                    dp[i][j] = true;
                if (cur < j)
                    dp[i][j] = dp[i][j] || dp[i - 1][j - cur];
            }
        }
        return dp[len][half];
    }

    /**
     * Your runtime beats 6.03 % of java submissions
     * Your memory usage beats 26.9 % of java submissions (42.2 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[n + 1][halfSum + 1];

        for (int i = 1; i <= n; i++) {
            int curValue = nums[i - 1];
            for (int j = 0; j <= halfSum; j++) {
                // 默认值为false;
                dp[i][j] = dp[i - 1][j];
                if (curValue == j) {
                    dp[i][j] = true;
                }
                if (curValue < j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - curValue];
                }
            }
        }
        return dp[n][halfSum];
    }
}
// @lc code=end
