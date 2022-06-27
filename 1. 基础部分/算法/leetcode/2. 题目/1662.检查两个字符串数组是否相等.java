/*
 * @lc app=leetcode.cn id=1662 lang=java
 *
 * [1662] 检查两个字符串数组是否相等
 */

// @lc code=start
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // 字符串拼接
        return extracted(word1, word2);

        // 双指针 -- 四指针
        // return extracted2(word1, word2);
    }

    private boolean extracted2(String[] word1, String[] word2) {
        // word1数组的下标
        int left = 0;
        // word2数组的下标
        int right = 0;
        // word1[left]字符串的偏移下标
        int i = 0;
        int j = 0;
        while (left < word1.length && right < word2.length) {
            if (word1[left].charAt(i) != word2[right].charAt(j)) {
                return false;
            }
            i++;
            if (i == word1[left].length()) {
                // word1[left]内部偏移完了，重置i，继续下一个word1数组字符串
                left++;
                i = 0;
            }
            j++;
            if (j == word2[right].length()) {
                right++;
                j = 0;
            }
        }
        return left == word1.length && right == word2.length;
    }

    /**
     * 109/109 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 53.73 % of java submissions (39.3 MB)
     * 
     * @param word1
     * @param word2
     * @return
     */
    private boolean extracted(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for (String temp : word1) {
            s1.append(temp);

        }
        StringBuilder s2 = new StringBuilder();
        for (String temp : word2) {
            s2.append(temp);
        }
        return s1.toString().equals(s2.toString());
    }
}
// @lc code=end
