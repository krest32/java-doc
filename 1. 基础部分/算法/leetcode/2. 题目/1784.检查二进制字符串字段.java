/*
 * @lc app=leetcode.cn id=1784 lang=java
 *
 * [1784] 检查二进制字符串字段
 */

// @lc code=start
class Solution {
    public boolean checkOnesSegment(String s) {
        return extracted(s);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 9.29 % of java submissions (39.7 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
