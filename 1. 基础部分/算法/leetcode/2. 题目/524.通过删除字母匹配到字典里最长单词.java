import java.util.List;

/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // 模拟
        return extracted(s, dictionary);
    }

    /**
     * 31/31 cases passed (17 ms)
     * Your runtime beats 81.58 % of java submissions
     * Your memory usage beats 93.44 % of java submissions (41.7 MB)
     * 
     * @param s
     * @param dictionary
     * @return
     */
    private String extracted(String s, List<String> dictionary) {
        String max_str = "";
        for (int i = 0; i < dictionary.size(); i++) {
            String str = dictionary.get(i);
            // 判断能否通过删除得到
            if (isLongestWord(s, str)) {
                /**
                 * 1.判断字符长度
                 * 2.判断字母序
                 */
                if (str.length() > max_str.length()
                        || (str.length() == max_str.length()
                                && str.compareTo(max_str) < 0)) {
                    max_str = str;
                }
            }
        }
        return max_str;
    }

    boolean isLongestWord(String s, String str) {
        int j = 0;
        for (int i = 0; i < s.length() && j < str.length(); i++) {
            if (str.charAt(j) == s.charAt(i)) {
                j++;
            }
        }
        return j == str.length();
    }
}
// @lc code=end
