/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        // 双指针
        // extracted(s);

        // 程序api
        extracted2(s);

    }

    /**
     * 477/477 cases passed (1 ms)
     * Your runtime beats 7.72 % of java submissions
     * Your memory usage beats 99.47 % of java submissions (47 MB)
     * 
     * @param s
     */
    private void extracted2(char[] s) {
        System.arraycopy(new StringBuilder(new String(s))
                .reverse().toString().toCharArray(), 0, s, 0, s.length);
    }

    /**
     * 477/477 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 77.3 % of java submissions (47.9 MB)
     * 
     * @param s
     */
    private void extracted(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
// @lc code=end
