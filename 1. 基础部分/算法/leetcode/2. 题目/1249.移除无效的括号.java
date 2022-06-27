/*
 * @lc app=leetcode.cn id=1249 lang=java
 *
 * [1249] 移除无效的括号
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        // 模拟 字符串
        return extracted(s);
    }

    /**
     * Your runtime beats 83.41 % of java submissions
     * Your memory usage beats 66.66 % of java submissions (41.6 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        StringBuilder res = new StringBuilder();
        int right = 0;
        int left = 0;
        // 记录括号的对数
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            }
            if (ch == ')' && left > right) {
                right++;
            }
        }
        System.out.print(right);
        left = right;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (left > 0) {
                    res.append(ch);
                    left--;
                }
            } else if (ch == ')') {
                if (right > left) {
                    res.append(")");
                    right--;
                }
            } else
                res.append(ch);
        }
        return res.toString();
    }
}
// @lc code=end
