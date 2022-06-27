/*
 * @lc app=leetcode.cn id=1941 lang=java
 *
 * [1941] 检查是否所有字符出现次数相同
 */
// @lc code=start
class Solution {
    public boolean areOccurrencesEqual(String s) {

        // 数组计数
        return extracted(s);
    }

    /**
     * 134/134 cases passed (1 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 75.93 % of java submissions (39.5 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray())
            cnt[ch - 'a']++;
        int cntCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (cntCnt == 0 && cnt[i] > 0) {
                cntCnt = cnt[i];
                continue;
            }
            if (cnt[i] > 0 && cnt[i] != cntCnt) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
