import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        return extracted(paragraph, banned);
    }

    /**
     * Your runtime beats 99.85 % of java submissions
     * Your memory usage beats 14.99 % of java submissions (41.4 MB)
     * 
     * @param paragraph
     * @param banned
     * @return
     */
    private String extracted(String paragraph, String[] banned) {
        paragraph += ".";
        // 刷新banned单词
        Set<String> banset = new HashSet<>();
        for (String word : banned)
            banset.add(word);
        // 使用Map记录每个单词出现的次数
        Map<String, Integer> count = new HashMap<>();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
}
// @lc code=end
