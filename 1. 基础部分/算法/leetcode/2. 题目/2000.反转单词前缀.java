/*
 * @lc app=leetcode.cn id=2000 lang=java
 *
 * [2000] 反转单词前缀
 */

// @lc code=start
class Solution {
    public String reversePrefix(String word, char ch) {
        // String Api
        return extracted(word, ch);
    }

    private String extracted(String word, char ch) {
        StringBuilder res = new StringBuilder(word);
        int idx = res.indexOf(String.valueOf(ch));
        if (idx < 0) {
            return word;
        }
        StringBuilder str1 = new StringBuilder(res.substring(0, idx + 1));
        String str2 = res.substring(idx + 1);
        StringBuilder ans = str1.reverse().append(str2);
        return ans.toString();
    }
}
// @lc code=end
