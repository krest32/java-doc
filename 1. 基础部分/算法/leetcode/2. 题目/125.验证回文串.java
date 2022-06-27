/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        // 方法一
        // return extracted(s);

        // 解法二 双指针 -> 最优解
        return extracted2(s);
    }

    /**
     * 首位双指针
     * 
     * Your runtime beats 96.41 % of java submissions
     * Your memory usage beats 45.1 % of java submissions (41 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    /**
     * 重新构建新的字符串
     * 
     * Your runtime beats 41.42 % of java submissions
     * Your memory usage beats 22.88 % of java submissions (41.4 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        // 遍历字符串
        for (int i = 0; i < len; i++) {
            Character ch = s.charAt(i);
            // 去掉非字符和数字，然后组成新的字符串
            if (Character.isLetterOrDigit(ch)) {
                res.append(Character.toLowerCase(ch));
            }
        }
        // 翻转字符串，然后生成新的字符串
        StringBuilder rev = new StringBuilder(res).reverse();
        return res.toString().equals(rev.toString());
    }
}
// @lc code=end
