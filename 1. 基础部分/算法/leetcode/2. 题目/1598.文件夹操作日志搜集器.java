/*
 * @lc app=leetcode.cn id=1598 lang=java
 *
 * [1598] 文件夹操作日志搜集器
 */

// @lc code=start
class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        // 遍历 数组
        for (String log : logs) {
            // 如果没有 . 那么就跳到子文件夹中
            if (log.charAt(0) != '.') {
                ans++;
                // 如果为../ 就返回上级目录
            } else if (ans != 0 && log.equals("../")) {
                ans--;
            }
        }
        return ans;
    }
}
// @lc code=end
