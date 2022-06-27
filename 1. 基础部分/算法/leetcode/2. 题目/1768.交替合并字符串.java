/*
 * @lc app=leetcode.cn id=1768 lang=java
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        // 双指针+模拟
        return extracted(word1, word2);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 70.74 % of java submissions (39.4 MB)
     * 
     * @param word1
     * @param word2
     * @return
     */
    private String extracted(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int idx1 = 0;
        int idx2 = 0;
        StringBuilder ans = new StringBuilder();
        while (idx1 < len1 && idx2 < len2) {
            ans.append(word1.charAt(idx1++));
            ans.append(word2.charAt(idx2++));
        }

        ans.append(idx1 == len1 ? word2.substring(idx2) : word1.substring(idx1));
        return ans.toString();
    }
}
// @lc code=end
