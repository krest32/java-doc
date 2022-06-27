import javax.lang.model.element.Element;

/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        // 动态规划
        // return extracted(nums);

        // 1
        return test(nums);
    }

    private boolean test(int[] nums) {
        int len = nums.length;
        // 记录数组为 i,j 时最大差值
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] >= 0;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 57.74 % of java submissions (38.7 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int length = nums.length;
        // dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，
        // 即在下标范围 [i, j]中，当前玩家与另一个玩家的分数之差的最大值，
        // 注意当前玩家不一定是先手。
        int[][] dp = new int[length][length];
        // 当 i=j 时，只剩一个数字，当前玩家只能拿取这个数字
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
// @lc code=end
