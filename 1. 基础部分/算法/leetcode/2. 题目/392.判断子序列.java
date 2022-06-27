/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        // 双指针 --> 最优解
        // return extracted(s, t);

        // 动态规划
        return extracted2(s, t);
    }

    /**
     * Your runtime beats 29.77 % of java submissions
     * Your memory usage beats 5.03 % of java submissions (41.6 MB)
     * 
     * @param s
     * @param t
     * @return
     */
    private boolean extracted2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    /**
     * Your runtime beats 88.11 % of java submissions
     * Your memory usage beats 44.19 % of java submissions (39.2 MB)
     * 
     * @param s
     * @param t
     * @return
     */
    private boolean extracted(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            while (tIndex < t.length() && t.charAt(tIndex) != s.charAt(sIndex)) {
                tIndex++;
            }
            if (tIndex < t.length() && s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            }
        }
        return sIndex == s.length();
    }
}
// @lc code=end
