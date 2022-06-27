/*
 * @lc app=leetcode.cn id=2129 lang=java
 *
 * [2129] 将标题首字母大写
 */

// @lc code=start
class Solution {
    public String capitalizeTitle(String title) {
        // 模拟
        return extracted(title);
    }

    /**
     * Your runtime beats 6.71 % of java submissions
     * Your memory usage beats 12.2 % of java submissions (41.1 MB)
     * 
     * @param title
     * @return
     */
    private String extracted(String title) {
        StringBuilder res = new StringBuilder();
        int len = title.length();
        // 将首字母大写
        for (int i = 0; i < len; i++) {
            char ch = title.charAt(i);
            if ((i == 0 && ch != ' ') || (i > 0 && ch != ' ' && title.charAt(i - 1) == ' ')) {
                int count = 0;
                int j = i;
                while (j < len && title.charAt(j) != ' ') {
                    j++;
                    count++;
                }
                if (count > 2) {
                    res.append(Character.toUpperCase(ch));
                } else {
                    res.append(Character.toLowerCase(ch));
                }
            } else {
                res.append(Character.toLowerCase(ch));
            }
        }
        return res.toString();
    }
}
// @lc code=end
