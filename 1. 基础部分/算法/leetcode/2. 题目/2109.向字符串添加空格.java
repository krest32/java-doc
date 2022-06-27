/*
 * @lc app=leetcode.cn id=2109 lang=java
 *
 * [2109] 向字符串添加空格
 */

// @lc code=start
class Solution {
    public String addSpaces(String s, int[] spaces) {
        // 模拟
        return extracted(s, spaces);
    }

    private String extracted(String s, int[] spaces) {
        int n = s.length();
        int sn = spaces.length;

        StringBuilder SB = new StringBuilder();
        int si = 0;
        int cnt = -1;
        for (int i = 0; i < n; i++) {
            cnt++;
            if (si < sn && cnt == spaces[si]) {
                SB.append(' ');
                si++;
            }
            SB.append(s.charAt(i));
        }
        return SB.toString();
    }
}
// @lc code=end
