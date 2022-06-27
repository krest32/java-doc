/*
 * @lc app=leetcode.cn id=1854 lang=java
 *
 * [1854] 人口最多的年份
 */

// @lc code=start
class Solution {
    public int maximumPopulation(int[][] logs) {
        // 暴力
        return extracted(logs);
    }

    /**
     * 52/52 cases passed (1 ms)
     * Your runtime beats 46.41 % of java submissions
     * Your memory usage beats 66.34 % of java submissions (39.4 MB)
     * 
     * @param logs
     * @return
     */
    private int extracted(int[][] logs) {
        int res = 0, cnt = 0;
        // 循环年份
        for (int i = 1950; i <= 2050; i++) {
            // 记录当前年份存活人数
            int s = 0;
            for (int[] log : logs)
                // 如果存活
                if (i >= log[0] && i < log[1])
                    s++;
            // 记录存活人数最大值
            if (s > cnt) {
                // 存活人数最多的年份
                res = i;
                cnt = s;
            }
        }
        return res;
    }
}
// @lc code=end
