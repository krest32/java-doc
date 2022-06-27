/*
 * @lc app=leetcode.cn id=1027 lang=java
 *
 * [1027] 最长等差数列
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length, ans = 0;
        int[][] dp = new int[len][1010];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 避免下标越界
                int d = nums[i] - nums[j] + 500;
                // dp[i][d]:表示第i个数，与前面的数以差为d时，能构成的最长等差数列长度。
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans + 1;
    }
}
// @lc code=end
