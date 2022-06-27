/*
 * @lc app=leetcode.cn id=1910 lang=java
 *
 * [1910] 删除一个字符串中所有出现的给定子字符串
 */

// @lc code=start
class Solution {
    public String removeOccurrences(String s, String part) {

        // 模擬
        // return extracted(s, part);
        
    }

    /**
     * Your runtime beats 51.06 % of java submissions
     * Your memory usage beats 15.96 % of java submissions (41.6 MB)
     * 
     * @param s
     * @param part
     * @return
     */
    private String extracted(String s, String part) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == part.charAt(0)
                    && s.substring(i).startsWith(part)) {
                StringBuilder sb = new StringBuilder();
                sb = sb.append(s.substring(0, i)).append(s.substring(i + part.length()));
                return removeOccurrences(sb.toString(), part);
            }
            if (i + part.length() >= len) {
                return s;
            }
        }
        return "";
    }
}
// @lc code=end
