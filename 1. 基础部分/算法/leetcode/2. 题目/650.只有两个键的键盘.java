
/*
 * @lc app=leetcode.cn id=650 lang=java
 *
 * [650] 只有两个键的键盘
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        // 动态规划
        // return extracted(n);

        // 1
        return test(n);
    }

    private int test(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = n;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }

    /**
     * 126/126 cases passed (3 ms)
     * Your runtime beats 65.34 % of java submissions
     * Your memory usage beats 52.49 % of java submissions (38.3 MB)
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        // dp[i] 表示到达 i 需要copy的最小次数
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // 设置一个默认的最大值
            dp[i] = n;
            // 有 两种 Copy 方式，其中 Copy All，需要满足 j*j<=i
            for (int j = 1; j * j <= i; j++) {
                // 满足 i 是 j的倍数，才可以得到最小的Copy次数
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end
