/*
 * @lc app=leetcode.cn id=1897 lang=java
 *
 * [1897] 重新分配字符使所有字符串都相等
 */

// @lc code=start
class Solution {
    public boolean makeEqual(String[] words) {
        // 模拟计数
        return extracted(words);
    }

    /**
     * Your runtime beats 95.24 % of java submissions
     * Your memory usage beats 29.76 % of java submissions (41.1 MB)
     * 
     * @param words
     * @return
     */
    private boolean extracted(String[] words) {
        int[] cnt = new int[26];
        for (String temp : words) {
            int len = temp.length();
            for (int i = 0; i < len; i++) {
                cnt[temp.charAt(i) - 'a']++;
            }
        }

        int len = words.length;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % len != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
