/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709]                                                                                                                                                                                                                     
 */

// @lc code=start
class Solution {
    public String toLowerCase(String s) {
        // 使用APi
        return extracted2(s);

        // 位运算
        // return extracted(s);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 7.29 % of java submissions (39.8 MB)
     * 
     * @param s
     * @return
     */
    private String extracted2(String s) {
        return s.toLowerCase();
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.04 % of java submissions (39.7 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
// @lc code=end
