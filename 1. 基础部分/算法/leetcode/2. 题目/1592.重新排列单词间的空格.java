import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1592 lang=java
 *
 * [1592] 重新排列单词间的空格
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String text) {
        // 模拟
        return extracted(text);
    }

    /**
     * 89/89 cases passed (1 ms)
     * Your runtime beats 90.42 % of java submissions
     * Your memory usage beats 31.25 % of java submissions (39.7 MB)
     * 
     * @param text
     * @return
     */
    private String extracted(String text) {
        StringBuilder sb = new StringBuilder();
        // 空格计数
        int spaceCnt = 0;
        // 存储单词
        List<String> words = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                // 空格数加1
                spaceCnt++;
            } else {
                int j = i + 1;
                while (j < text.length() && text.charAt(j) != ' ') {
                    j++;
                }
                // 加入words
                words.add(text.substring(i, j));
                i = j - 1;
            }
        }
        // 特判只有1个单词的情况，避免”除0异常“
        if (words.size() == 1) {
            // 拼接上唯一的单词
            sb.append(words.get(0));
            // 拼接上所有的空格
            for (int i = 0; i < spaceCnt; i++) {
                sb.append(' ');
            }
        } else {
            // 间隔数
            int gap = spaceCnt / (words.size() - 1);
            // 单词间的空格
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < gap; i++) {
                space.append(' ');
            }
            // 剩余数
            int left = spaceCnt % (words.size() - 1);
            for (int i = 0; i < words.size(); i++) {
                // 拼接单词
                sb.append(words.get(i));
                // 拼接空格
                if (i != words.size() - 1) {
                    sb.append(space);
                }
            }
            // 如果有剩余的，拼接到末尾
            for (int i = 0; i < left; i++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
// @lc code=end
