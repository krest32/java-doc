import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1986 lang=java
 *
 * [1986] 完成任务的最少工作时间段
 */

// @lc code=start
class Solution {
    int ans = Integer.MAX_VALUE;

    public int minSessions(int[] tasks, int sessionTime) {
        // 动态规划 状态压缩
        return extracted(tasks, sessionTime);
    }



    /**
     * Your runtime beats 85.81 % of java submissions
     * Your memory usage beats 63.51 % of java submissions (40.5 MB)
     * 
     * @param tasks
     * @param sessionTime
     * @return
     */
    private int extracted(int[] tasks, int sessionTime) {
        int n = tasks.length, m = 1 << n;
        final int INF = 20;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);

        // 预处理每个状态，合法状态预设为 1
        for (int i = 1; i < m; i++) {
            int state = i, idx = 0;
            int spend = 0;
            while (state > 0) {
                int bit = state & 1;
                if (bit == 1) {
                    spend += tasks[idx];
                }
                state >>= 1;
                idx++;
            }
            if (spend <= sessionTime) {
                dp[i] = 1;
            }
        }
        // 对每个状态枚举子集，跳过已经有最优解的状态
        for (int i = 1; i < m; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int split = i >> 1;
            // 由于转移是由子集与补集得来，因此可以将子集分割为两块，避免重复枚举
            for (int j = (i - 1) & i; j > split; j = (j - 1) & i) {
                // i 状态的最优解可能由当前子集 j 与子集 j 的补集得来
                dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
            }
        }

        return dp[m - 1];
    }
}
// @lc code=end
