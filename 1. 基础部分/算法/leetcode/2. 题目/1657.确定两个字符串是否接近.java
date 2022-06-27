import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1657 lang=java
 *
 * [1657] 确定两个字符串是否接近
 */

// @lc code=start
class Solution {
    public boolean closeStrings(String word1, String word2) {
        return extracted(word1, word2);
    }

    private boolean extracted(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        if (chars1.length == chars2.length) {
            int[] mark1 = new int[26];
            int[] mark2 = new int[26];

            for (char c : chars1) {
                mark1[c - 'a']++;
            }
            for (char c : chars2) {
                if (mark1[c - 'a'] == 0) {
                    return false;
                }
                mark2[c - 'a']++;
            }
            Arrays.sort(mark1);
            Arrays.sort(mark2);
            for (int i = 0; i < mark1.length; i++) {
                if (mark1[i] != mark2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
// @lc code=end
