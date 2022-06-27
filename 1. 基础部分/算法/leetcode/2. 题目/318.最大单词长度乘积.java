import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        // 位运算
        // return extracted(words);

        // 哈希实现 -- > 效率有些低
        return extracted2(words);

    }

    /**
     * Your runtime beats 8.93 % of java submissions
     * Your memory usage beats 13.19 % of java submissions (41.6 MB)
     * 
     * @param words
     * @return
     */
    private int extracted2(String[] words) {
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String A = words[i];
                String B = words[j];
                if (check(A, B)) {
                    ret = Math.max(ret, A.length() * B.length());
                }
            }
        }
        return ret;
    }

    private boolean check(String a, String b) {
        int[] cntA = new int[26];
        int[] cntB = new int[26];
        for (char ch : a.toCharArray()) {
            cntA[ch - 'a']++;
        }

        for (char ch : b.toCharArray()) {
            cntB[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // 说明两个字符串有相同字符
            if (cntA[i] != 0 && cntB[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private int extracted(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int t = 0, m = w.length();
            for (int i = 0; i < m; i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            if (!map.containsKey(t) || map.get(t) < m)
                map.put(t, m);
        }
        int ans = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if ((a & b) == 0)
                    ans = Math.max(ans, map.get(a) * map.get(b));
            }
        }
        return ans;
    }
}
// @lc code=end
