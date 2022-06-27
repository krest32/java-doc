import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1408 lang=java
 *
 * [1408] 数组中的字符串匹配
 */

// @lc code=start
class Solution {
    public List<String> stringMatching(String[] words) {
        // 模拟+String Api
        return extracted(words);
    }

    private List<String> extracted(String[] words) {
        List<String> list = new ArrayList<>();
        Arrays.sort(words, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 直接判断短的字符串能否作为长字符串中的索引,
                // 牛逼！！！！
                if (words[j].indexOf(words[i]) >= 0) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }
}
// @lc code=end
