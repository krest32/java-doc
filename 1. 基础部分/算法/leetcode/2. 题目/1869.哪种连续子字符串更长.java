/*
 * @lc app=leetcode.cn id=1869 lang=java
 *
 * [1869] 哪种连续子字符串更长
 */

// @lc code=start
class Solution {
    public boolean checkZeroOnes(String s) {
        // 模拟计数
        return extracted(s);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 48.44 % of java submissions (39.4 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted(String s) {
        int cnt1 = 0, cnt0 = 0, len = s.length();
        int ans1 = 0, ans0 = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) - '0' == 1) {
                cnt1++;
                ans0 = Math.max(ans0, cnt0);
                cnt0 = 0;
            } else {
                ans1 = Math.max(ans1, cnt1);
                cnt1 = 0;
                cnt0++;
            }
        }
        ans0 = Math.max(ans0, cnt0);
        ans1 = Math.max(ans1, cnt1);
        return ans1 > ans0;
    }
}
// @lc code=end
