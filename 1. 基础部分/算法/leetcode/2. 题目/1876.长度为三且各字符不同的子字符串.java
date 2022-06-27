import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1876 lang=java
 *
 * [1876] 长度为三且各字符不同的子字符串
 */

// @lc code=start
class Solution {
    public int countGoodSubstrings(String s) {

        // 暴力
        // return extracted(s);

        // 暴力
        // return extracted2(s);

        // 最优解：滑动窗口
        return extracted3(s);
    }

    /**
     * 160/160 cases passed (1 ms)
     * Your runtime beats 76.37 % of java submissions
     * Your memory usage beats 40.25 % of java submissions (39.7 MB)
     * 
     * @param s
     * @return
     */
    private int extracted3(String s) {
        int left = 0;
        int right = 2;
        int i, j;
        boolean flags = true;
        int count = 0;

        // 始终维持一个长度为3的字符窗口
        while (right < s.length()) {
            flags = true;
            for (i = left; i < left + 2; i++) {
                for (j = i + 1; j <= left + 2; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        flags = false;
                        break;
                    }
                }
            }
            if (flags)
                count++;

            left++;
            right++;
        }
        return count;
    }

    /**
     * Your runtime beats 5.53 % of java submissions
     * Your memory usage beats 5.16 % of java submissions (41.6 MB)
     * 
     * @param s
     * @return
     */
    private int extracted2(String s) {
        int n = s.length();
        int res = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < n) {
            char r = s.charAt(right++);
            window.put(r, window.getOrDefault(r, 0) + 1);

            while (right - left == 3) {
                if (window.entrySet().stream().parallel().filter(e -> e.getValue() == 1).count() == 3)
                    res++;
                char l = s.charAt(left++);
                window.put(l, window.get(l) - 1);
            }
        }
        return res;
    }

    /**
     * 160/160 cases passed (9 ms)
     * Your runtime beats 5.08 % of java submissions
     * Your memory usage beats 18.13 % of java submissions (41 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        int l = s.length();
        String c = "";
        String cc = "";
        int lm = 0;
        int res = 0;
        int rm = lm + 3;
        while (rm <= l) {
            c = s.substring(lm, rm);
            for (int i = 0; i < c.length(); i++) {
                if (i == 0)
                    cc = c.charAt(i) + "";
                else if (cc.contains(c.charAt(i) + "")) {
                    break;
                } else {
                    cc += c.charAt(i) + "";
                    continue;
                }
            }
            if (cc.length() == 3)
                res++;
            cc = "";
            lm++;
            rm++;
        }
        return res;
    }
}
// @lc code=end
