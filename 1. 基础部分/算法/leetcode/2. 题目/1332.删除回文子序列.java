/*
 * @lc app=leetcode.cn id=1332 lang=java
 *
 * [1332] 删除回文子序列
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        // 如果该字符串本身为回文串，
        // 此时只需删除 1 次即可，删除次数为 1。
        // 如果该字符串本身不是回文串，此时只需删除 2 次即可，
        // 比如可以先删除所有的 ‘a’，再删除所有的
        // ‘b’，删除次数为 2

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return 2;
            }
        }
        return 1;
    }
}
// @lc code=end
