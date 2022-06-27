/*
 * @lc app=leetcode.cn id=1455 lang=java
 *
 * [1455] 检查单词是否为句中其他单词的前缀
 */

// @lc code=start
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // 模拟
        return extracted(sentence, searchWord);
    }

    private int extracted(String sentence, String searchWord) {
        int idx = 1;
        for (String str : sentence.split(" ")) {
            if (str.startsWith(searchWord)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}
// @lc code=end
