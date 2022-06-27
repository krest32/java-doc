/*
 * @lc app=leetcode.cn id=1450 lang=java
 *
 * [1450] 在既定时间做作业的学生人数
 */

// @lc code=start
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // 简单模拟
        return extracted(startTime, endTime, queryTime);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 67.13 % of java submissions (39.3 MB)
     * 
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    private int extracted(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int len = startTime.length;
        for (int i = 0; i < len; i++) {
            int left = startTime[i];
            int end = endTime[i];
            if (queryTime >= left && queryTime <= end) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
