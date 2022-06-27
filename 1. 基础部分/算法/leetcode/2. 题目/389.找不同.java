import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        // 哈希
        // return extracted(s, t);

        // 模拟
        // return extracted2(s, t);

        // 求和
        return extracted3(s, t);

        // 位运算
        // return extracted4(s, t);

    }

    /**
     * Your runtime beats 74.21 % of java submissions
     * Your memory usage beats 19.84 % of java submissions (39.7 MB)
     * 
     * @param s
     * @param t
     * @return
     */
    private char extracted4(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

    /**
     * Your runtime beats 74.21 % of java submissions
     * Your memory usage beats 43.41 % of java submissions (39.4 MB)
     */
    private char extracted3(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * Your runtime beats 41.42 % of java submissions
     * Your memory usage beats 45.71 % of java submissions (39.4 MB)
     */
    private char extracted2(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * Your runtime beats 8.3 % of java submissions
     * Your memory usage beats 14.66 % of java submissions (39.8 MB)
     * 
     * @param s
     * @param t
     * @return
     */
    private char extracted(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Integer num = map.getOrDefault(t.charAt(i), 0);
            if (num == 0) {
                return t.charAt(i);
            } else if (num > 0) {
                num = num - 1;
                map.put(t.charAt(i), num);
            }
        }
        return ' ';
    }
}
// @lc code=end
