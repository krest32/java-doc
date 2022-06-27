import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        // 排序
        // return extracted(s, t);

        // 哈希表
        return extracted2(s, t);
    }

    /**
     * Your runtime beats 63.79 % of java submissions
     * Your memory usage beats 47.9 % of java submissions (41.1 MB)
     */
    private boolean extracted2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序
     * Your runtime beats 78.88 % of java submissions
     * Your memory usage beats 38.22 % of java submissions (41.3 MB)
     * 
     * @param s
     * @param t
     * @return
     */
    private boolean extracted(String s, String t) {
        /**
         * 字符串转化为数组，然后排序进行比较
         */
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }
}
// @lc code=end
