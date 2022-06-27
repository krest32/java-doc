/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        return extracted(num);
    }

    /**
     * 241/241 cases passed (1 ms)
     * Your runtime beats 77.39 % of java submissions
     * Your memory usage beats 10.54 % of java submissions (39.2 MB)
     * 
     *
     * @param num
     * @return
     */
    private String extracted(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuffer digits = new StringBuffer();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative) {
            digits.append('-');
        }
        return digits.reverse().toString();
    }
}
// @lc code=end
