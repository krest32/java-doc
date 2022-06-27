import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1805 lang=java
 *
 * [1805] 字符串中不同整数的数目
 */

// @lc code=start
class Solution {
    public int numDifferentIntegers(String word) {
        // 模拟
        return extracted(word);
    }

    private int extracted(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                // 去除前导0
                while (i < word.length() && word.charAt(i) == '0') {
                    i++;
                }
                while (i < word.length() && Character.isDigit(word.charAt(i))) {
                    sb.append(word.charAt(i));
                    i++;
                }
                i -= 1;
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
// @lc code=end
