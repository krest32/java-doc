import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1525 lang=java
 *
 * [1525] 字符串的好分割数目
 */

// @lc code=start
class Solution {
    public int numSplits(String s) {
        // 暴力 --> 超时
        // return extracted(s);

        // 双向动态规划--> 基础版
        return extracted2(s);

        // 双向动态规划 --> 优化版
        // return extracted3(s);

    }

    /**
     * Your runtime beats 38 % of java submissions
     * Your memory usage beats 16 % of java submissions (42 MB)
     * 
     * @param s
     * @return
     */
    private int extracted3(String s) {
        int len = s.length();
        int[] dp1 = new int[len + 1];
        int[] dp2 = new int[len + 1];

        // 记录每个位置的不同字符个数
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set1.add(s.charAt(i));
            set2.add(s.charAt(len - 1 - i));
            dp1[i] = set1.size();
            dp2[len - i - 1] = set2.size();
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (dp1[i] == dp2[i + 1]) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * Your runtime beats 42.5 % of java submissions
     * Your memory usage beats 38.5 % of java submissions (41.6 MB)
     * 
     * @param s
     * @return
     */
    private int extracted2(String s) {
        int len = s.length();
        int[] dp1 = new int[len + 1];
        int[] dp2 = new int[len + 1];

        // 记录每个位置的不同字符个数
        Set<Character> set1 = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set1.add(s.charAt(i));
            dp1[i] = set1.size();
        }
        Set<Character> set2 = new HashSet<>();
        for (int i = len - 1; i >= 0; i--) {
            set2.add(s.charAt(i));
            dp2[i] = set2.size();
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (dp1[i] == dp2[i + 1]) {
                ret++;
            }
        }
        return ret;
    }

    private int extracted(String s) {
        int len = s.length();
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (check(s.substring(0, i)) == check(s.substring(i, len))) {
                ret++;
            }
        }
        return ret;
    }

    private int check(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size();
    }
}
// @lc code=end
