import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=890 lang=java
 *
 * [890] 查找和替换模式
 */

// @lc code=start
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // 哈希映射
        return extracted(words, pattern);
    }

    /**
     * Your runtime beats 36.99 % of java submissions
     * Your memory usage beats 52.6 % of java submissions (41 MB)
     * 
     * @param words
     * @param pattern
     * @return
     */
    private List<String> extracted(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int len = pattern.length();
        for (String str : words) {
            if (str.length() != pattern.length()) {
                continue;
            }
            // 对应字符的数量是否一致
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            int idx = 0;
            Map<Character, Character> map = new HashMap<>();
            for (; idx < len; idx++) {
                cnt1[str.charAt(idx) - 'a']++;
                cnt2[pattern.charAt(idx) - 'a']++;
                // 对应的字符类型是否一致
                if (map.containsKey(pattern.charAt(idx))) {
                    char pair = map.get(pattern.charAt(idx));
                    if (pair != str.charAt(idx)) {
                        break;
                    }
                } else {
                    map.put(pattern.charAt(idx), str.charAt(idx));
                }
                if (cnt1[str.charAt(idx) - 'a'] != cnt2[pattern.charAt(idx) - 'a']) {
                    break;
                }
            }
            if (idx >= len) {
                ans.add(str);
            }
        }
        return ans;
    }
}
// @lc code=end
