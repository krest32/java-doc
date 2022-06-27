/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        // 相对与求取26进制
        while (columnNumber != 0) {
            // 一定要先自减 1
            columnNumber--;
            // 每次对26进行取余，然后+A，获取26个字符中的其中一个
            res.append((char) (columnNumber % 26 + 'A'));
            // 除去一个循环
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
// @lc code=end
