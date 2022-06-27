/*
 * @lc app=leetcode.cn id=1156 lang=java
 *
 * [1156] 单字符重复子串的最大长度
 */

// @lc code=start
class Solution {
    public int maxRepOpt1(String text) {
        // 滑动窗口 --> 太多的边界条件，恶心到吐
        return extracted(text);
    }

    /**
     * 60/60 cases passed (2 ms)
     * Your runtime beats 99.43 % of java submissions
     * Your memory usage beats 87.14 % of java submissions (39.6 MB)
     * 
     * @param text
     * @return
     */
    private int extracted(String text) {
        char[] cs = text.toCharArray();
        // 每个字符计数
        int[] dics = new int[26];
        for (char c : cs) {
            dics[c - 'a'] += 1;
        }
        int len = cs.length;
        // 窗口内，第一个字符和数量
        char A = cs[0], last = A;
        int a = 1;
        int l = 0, r = 1;
        while (r < len && cs[r] == last) {
            r++;
            a++;
        }
        // 有可能就一个啊
        if (r == len || r == len - 1) {
            return r;
        }
        // 窗口里第二个字符
        char B = cs[r];
        last = B;
        int b = 1;
        r++;
        int ans = 0;
        while (r <= len) {
            char cur = r < len ? cs[r] : ' ';
            if (cur == A && a >= 1 && b <= 1) {
                // 窗口中不唯一的字符是A字符，A字符+1；
                a++;
                r++;
            } else if (cur == B && b >= 1 && a <= 1) {
                // 窗口中不唯一的字符是B字符，B字符+1；
                b++;
                r++;
            } else {
                // 窗口结构破坏，现有窗口内数字结算
                if (a == 1) {
                    // A是独苗，结算B
                    if (dics[B - 'a'] > b) {
                        ans = Math.max(ans, b + 1);
                    } else {
                        ans = Math.max(ans, b);
                    }
                } else {
                    // B是独苗，结算A
                    if (dics[A - 'a'] > a) {
                        ans = Math.max(ans, a + 1);
                    } else {
                        ans = Math.max(ans, a);
                    }
                }
                if (cur != A && cur != B) {
                    // cur不是A，B中一个。将a，b其中一个清空
                    while (a > 0 && b > 0) {
                        char c = cs[l++];
                        if (c == A) {
                            a--;
                        } else {
                            b--;
                        }
                    }
                    // 让A拿着不为空的字符信息
                    if (a == 0) {
                        A = B;
                        a = b;
                    }
                    // 找到B的字符信息。
                    while (r < len && cs[r] == A) {
                        a++;
                        r++;
                    }
                    if (r < len) {
                        B = cs[r];
                        b = 1;
                    }
                } else {
                    // 如果cur是A,B中一个，先加入进来
                    if (cur == A) {
                        a++;
                    } else {
                        b++;
                    }
                    // 将两个字符，变成不会同时存在两个字符都有两个以上的情况。至少有1个变成1
                    while (a > 1 && b > 1) {
                        char c = cs[l++];
                        if (c == A) {
                            a--;
                        } else {
                            b--;
                        }
                    }
                }
                r++;
            }
        }
        return ans;
    }
}
// @lc code=end
