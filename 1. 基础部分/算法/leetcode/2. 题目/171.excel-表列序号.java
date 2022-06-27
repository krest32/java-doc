/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        // 从头开始遍历
        for (int i = 0; i < columnTitle.length(); i++) {
            // 每遍历一个字符+1
            int num = columnTitle.charAt(i) - 'A' + 1;
            // 然后 相当于26进制
            ans = ans * 26 + num;
        }
        return ans;
    }
}
// @lc code=end
