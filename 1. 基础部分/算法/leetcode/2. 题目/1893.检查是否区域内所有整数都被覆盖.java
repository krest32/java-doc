
/*
 * @lc app=leetcode.cn id=1893 lang=java
 *
 * [1893] 检查是否区域内所有整数都被覆盖
 */

// @lc code=start
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 暴力
        return extracted(ranges, left, right);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 75.71 % of java submissions (39.2 MB)
     * 
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    private boolean extracted(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean ok = false;
            for (int[] cur : ranges) {
                int a = cur[0], b = cur[1];
                if (a <= i && i <= b) {
                    ok = true;
                    break;
                }
            }
            if (!ok)
                return false;
        }
        return true;
    }
}
// @lc code=end
