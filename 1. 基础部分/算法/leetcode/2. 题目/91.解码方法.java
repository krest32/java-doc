/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        // 动态规划
        // return extracted(s);

        // 2
        return test(s);
    }

    private int test(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1
                    && s.charAt(i - 2) != '0'
                    && ((s.charAt(i - 2) - '0') * 10
                            + (s.charAt(i - 1) - '0')) <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    /**
     * 269/269 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 42.74 % of java submissions (39.7 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        int n = s.length();
        // dp[i] 记录到达 i 位置，前面字符移动有多少中组合的可能性
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0'
                    && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
// @lc code=end
