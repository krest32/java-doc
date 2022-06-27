import javax.swing.text.AbstractDocument.Content;

/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 */

// @lc code=start
class Solution {
    public int repeatedStringMatch(String a, String b) {
        // 暴力 --> 第56/57超时
        // return extracted(a, b);

        // KMP算法
        return extracted2(a, b);
    }

    /**
     * Your runtime beats 81.45 % of java submissions
     * Your memory usage beats 5 % of java submissions (39.8 MB)
     * 
     * @param a
     * @param b
     * @return
     */
    private int extracted2(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i - j < n; i++) { // b 开始匹配的位置是否超过第一个叠加的 a
            while (j > 0 && haystack.charAt(i % n) != needle.charAt(j)) { // haystack 是循环叠加的字符串，所以取 i % n
                j = pi[j - 1];
            }
            if (haystack.charAt(i % n) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private int extracted(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int count = Math.max(lenA, lenB);
        int idx = 1;
        StringBuilder ans = new StringBuilder();
        while (idx <= count) {
            ans.append(a);
            if (ans.indexOf(b) >= 0) {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}
// @lc code=end
