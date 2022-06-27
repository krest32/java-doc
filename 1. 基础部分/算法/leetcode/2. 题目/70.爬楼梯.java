/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        // 动态方程：dp[i] = dp[i-1] + dp[i-2]

        // 方法一 动态规划1 最优解->去掉了不必要的数据
        // return extracted(n);

        // 方法二 动态规划2 : 保存了所有的计算值，空间上会有一些浪费
        return extracted2(n);

    }

    /**
     * 动态规划2
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 23.91 % of java submissions (38.2 MB)
     * 
     * @param n
     * @return
     */
    private int extracted2(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 动态规划1
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 32.87 % of java submissions (38.1 MB)
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        // f(x) = f(x-1)+f(x-2)
        // 动态规划
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
// @lc code=end
