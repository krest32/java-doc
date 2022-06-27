
/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        // 解法一： 暴力解法： 整体效率有限
        // return extracted(haystack, needle);

        // 解法二： KMP 效率提升明显（暂时仅仅了解）
        return extracted2(haystack, needle);
    }

    /**
     * KMP 算法 --> 前缀函数，核心求取next指针数组
     * 
     * Your runtime beats 90.4 % of java submissions
     * Your memory usage beats 40.16 % of java submissions (41 MB)
     * 
     * @param haystack
     * @param needle
     * @return
     */
    private int extracted2(String ss, String pp) {
        if (pp.isEmpty())
            return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1])
                j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1])
                j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1])
                j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1])
                j++;
            // 整一段匹配成功，直接返回下标
            if (j == m)
                return i - m;
        
        return -1;
    }

    /**
     * 暴力解法
     * 
     * Your runtime beats 62.59 % of java submissions
     * Your memory usage beats 5.02 % of java submissions (42 MB)
     * 
     * @param haystack
     * @param needle
     * @return
     */
    private int extracted(String haystack, String needle) {
        int lh = haystack.length();
        int ln = needle.length();
        //
        if (ln > lh)
            return -1;
        // 两个作用 1. 针对空字符串进行处理，2. 针对相同的字符串直接进行判断
        if (ln == lh && haystack.equals(needle))
            return 0;
        // 注意：下面代码不能针对 string="" 的情况进行处理
        for (int i = 0; i < lh; i++) {
            if ((i + ln) <= lh
                    && needle.equals(haystack.substring(i, i + ln))) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
