/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 动态规划 --> 多重背包？
        // return extracted(nums, target);

        // 1
        return test(nums, target);
    }

    private int test(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    /**
     * Your runtime beats 97.83 % of java submissions
     * Your memory usage beats 12.44 % of java submissions (39 MB)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int extracted(int[] nums, int target) {
        // 用来储存每个数存在组成targe的可能性
        int[] dp = new int[target + 1];
        // 初始化，和为 0，只有一种可能性
        dp[0] = 1;
        // 开始获取每个输的可能性
        for (int i = 1; i <= target; i++) {
            // 遍历数组
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end
