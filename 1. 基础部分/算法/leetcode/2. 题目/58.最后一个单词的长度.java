import java.io.FileReader;

import javax.swing.text.AbstractDocument.BranchElement;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    /**
     * 反向遍历
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        // 记录最后一个单词的长度
        int index = 0;
        // 从后向前遍历数组
        for (int i = s.length() - 1; i >= 0; i--) {
            // 记录最后一个单词的长度
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
                index++;
            }
            if (index > 0) {
                break;
            }
        }
        return index;
    }
}
// @lc code=end
