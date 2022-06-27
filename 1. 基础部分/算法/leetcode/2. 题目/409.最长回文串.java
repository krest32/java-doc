/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] ins = new int[128];
        char[] chs = s.toCharArray();
        int res = 0;
        for (char now : chs) {
            ins[now - 0]++;
            if (ins[now - 0] % 2 == 0) {
                res += 2;
            }
        }
        if (res < chs.length) {
            return res + 1;
        }
        return res;

    }
}
// @lc code=end
