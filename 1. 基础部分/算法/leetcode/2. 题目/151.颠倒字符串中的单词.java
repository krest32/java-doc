/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {

        // 模拟
        return extracted(s);
    }

    /**
     * Your runtime beats 52.57 % of java submissions
     * Your memory usage beats 54.04 % of java submissions (41.1 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].indexOf(" ") >= 0 || str[i].indexOf(' ') >= 0) {
                continue;
            }
            if (str[i].length() > 0) {
                if (i != 0) {
                    ret.append(str[i] + " ");
                } else {
                    ret.append(str[i]);
                }
            }
        }

        return ret.toString();
    }
}
// @lc code=end
