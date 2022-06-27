

/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 动态规划
        return extracted(s1, s2, s3);
    }

    private boolean extracted(String s1, String s2, String s3) {
        // dp[i][j] = true, 表示s3的[i+j-1],可以是S1的[i]与s2[j]之前的字符组成
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int idx = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] ||
                            (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(idx));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j]
                            || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(idx));
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end
