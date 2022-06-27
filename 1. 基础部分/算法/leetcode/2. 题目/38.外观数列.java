/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        // 模拟
        return extracted(n);

    }

    /**
     * Your runtime beats 48.64 % of java submissions
     * Your memory usage beats 23.5 % of java submissions (40.5 MB)
     * 
     * @param n
     * @return
     */
    private String extracted(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < str.length()) {
                while (pos < str.length()
                        && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start))
                        .append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }
}
// @lc code=end
