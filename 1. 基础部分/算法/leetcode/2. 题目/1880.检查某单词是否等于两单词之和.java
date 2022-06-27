/*
 * @lc app=leetcode.cn id=1880 lang=java
 *
 * [1880] 检查某单词是否等于两单词之和
 */

// @lc code=start
class Solution {
    public int wordToSum(String w) {
        int ans = 0;
        for (int i = 0; i < w.length(); ++i) {
            ans *= 10;
            ans += w.charAt(i) - 'a';
        }
        return ans;
    }

    public boolean isSumEqual(String w1, String w2, String w3) {
        return wordToSum(w1) + wordToSum(w2) == wordToSum(w3);
    }
}
// @lc code=end
