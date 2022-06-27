import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1223 lang=java
 *
 * [1223] 掷骰子模拟
 */

// @lc code=start
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n][6];
        for (int i = 0; i < 6; i++)
            dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dp[i][j] = Arrays.stream(dp[i - 1]).reduce(0, (a, b) -> (a + b) % MOD);
                // 参见算法部分第2条
                if (i == rollMax[j])
                    dp[i][j]--;
                else if (i > rollMax[j]) {
                    for (int k = 0; k < 6; k++) {
                        if (j != k)
                            dp[i][j] = (dp[i][j] - dp[i - rollMax[j] - 1][k] + MOD) % MOD;
                    }
                }
            }
        }
        return Arrays.stream(dp[n - 1]).reduce(0, (a, b) -> (a + b) % MOD);

    }
}
// @lc code=end
