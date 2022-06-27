/*
 * @lc app=leetcode.cn id=1967 lang=java
 *
 * [1967] 作为子字符串出现在单词中的字符串数目
 */

// @lc code=start
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        // 暴力 解法
        return extracted(patterns, word);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 11.66 % of java submissions (40.1 MB)
     * 
     * @param patterns
     * @param word
     * @return
     */
    private int extracted(String[] patterns, String word) {
        int idx = 0;
        int len = patterns.length;
        for (int i = 0; i < len; i++) {
            if (word.indexOf(patterns[i]) >= 0) {
                idx++;
            }
        }
        return idx;
    }
}
// @lc code=end
