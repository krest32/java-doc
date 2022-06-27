/*
 * @lc app=leetcode.cn id=2114 lang=java
 *
 * [2114] 句子中的最多单词数
 */

// @lc code=start
class Solution {
    public int mostWordsFound(String[] sentences) {
        // 模拟
        return extracted(sentences);
    }

    private int extracted(String[] sentences) {
        int mostWords = 0;

        for (String sent : sentences) {
            int spaceNums = 0;
            for (int i = 0; i < sent.length(); i++) {
                if (sent.charAt(i) == ' ') {
                    spaceNums++;
                }
            }
            spaceNums += 1;
            if (spaceNums > mostWords) {
                mostWords = spaceNums;
            }
        }

        return mostWords;
    }
}
// @lc code=end
