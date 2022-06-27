/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {

        // 动态规划
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        /**
         * '为了避免重复比较
         * A[i:] 与 B[j:] 的最长公共前缀为
         * A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加一
         * dp[i][j] = dp[i + 1][j + 1] + 1
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = 0;
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
// @lc code=end
