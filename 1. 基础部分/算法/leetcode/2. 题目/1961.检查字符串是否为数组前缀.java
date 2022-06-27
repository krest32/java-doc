/*
 * @lc app=leetcode.cn id=1961 lang=java
 *
 * [1961] 检查字符串是否为数组前缀
 */

// @lc code=start
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        // 模拟
        return extracted(s, words);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 17.31 % of java submissions (41.4 MB)
     * 
     * @param s
     * @param words
     * @return
     */
    private boolean extracted(String s, String[] words) {
        int len = words.length;
        int strLen = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (res.length() < strLen) {
                res.append(words[i]);
            } else if (res.length() == strLen) {
                break;
            } else {
                return false;
            }
        }
        return s.equals(res.toString());
    }
}
// @lc code=end
