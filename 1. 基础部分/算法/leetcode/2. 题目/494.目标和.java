import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        // 回溯算法
        // return extracted(nums, target);

        // 二维数组 动态规划 -- 01 背包
        // return extracted2(nums, target);

        // 一维数组 动态规划 -- 01 背包
        return extracted3(nums, target);
    }

    private int extracted3(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if ((target + sum) % 2 != 0)
            return 0;
        int size = (target + sum) / 2;
        if (size < 0)
            size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }

    private int extracted2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0)
            return 0;

        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    private int extracted(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }
}
// @lc code=end
