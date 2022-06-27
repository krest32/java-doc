/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // dp[i]记录从开始到i,一共有多少个等差数列
        // 动态规划
        return extracted(A);
    }

    private int extracted(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}

// @lc code=end
