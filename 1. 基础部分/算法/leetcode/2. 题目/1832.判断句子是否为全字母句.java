/*
 * @lc app=leetcode.cn id=1832 lang=java
 *
 * [1832] 判断句子是否为全字母句
 */

// @lc code=start
class Solution {
    public boolean checkIfPangram(String sentence) {
        // 模拟，字符数组进行计数
        return extracted(sentence);
    }

    /**
     * 79/79 cases passed (1 ms)
     * Your runtime beats 86.56 % of java submissions
     * Your memory usage beats 75.88 % of java submissions (39.2 MB)
     * 
     * @param sentence
     * @return
     */
    private boolean extracted(String sentence) {
        int[] ans = new int[26];
        for (char ch : sentence.toCharArray()) {
            ans[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ans[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
