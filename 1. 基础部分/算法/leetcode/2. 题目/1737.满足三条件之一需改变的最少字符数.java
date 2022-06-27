/*
 * @lc app=leetcode.cn id=1737 lang=java
 *
 * [1737] 满足三条件之一需改变的最少字符数
 */

// @lc code=start
class Solution {
    public int minCharacters(String a, String b) {
        // 贪心
        // return extracted(a, b);

        // 1
        return test(a, b);
    }

    private int test(String a, String b) {
        int[] acnt = new int[26];
        int[] bcnt = new int[26];
        int alen = a.length();
        int blen = b.length();
        for (char ch : a.toCharArray())
            acnt[ch - 'a']++;
        for (char ch : b.toCharArray())
            bcnt[ch - 'a']++;
        int ans = Integer.MAX_VALUE, ans_1, ans_2, asum = 0, bsum = 0;
        for (int i = 0; i < 25; i++) {
            asum += acnt[i];
            bsum += bcnt[i];
            // 不能统计字符Z的情况，Z不满足，举例字符串是"a"和"aazz"
            ans_1 = Math.min(alen - asum + bsum, blen - bsum + asum);
            ans_2 = Math.min(ans, alen - acnt[i] + blen - bcnt[i]);
            ans = Math.min(ans_1, ans_2);
        }
        // 计算全部替换为Z的情况
        ans = Math.min(ans, alen - acnt[25] + blen - bcnt[25]);
        return ans;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 9.76 % of java submissions (42.1 MB)
     * 
     * @param a
     * @param b
     * @return
     */
    private int extracted(String a, String b) {
        int[] acnt = new int[26];
        int[] bcnt = new int[26];
        int alen = a.length(), blen = b.length();
        for (char c : a.toCharArray())
            acnt[c - 'a']++;
        for (char c : b.toCharArray())
            bcnt[c - 'a']++;

        int ans = Integer.MAX_VALUE, ans_1, ans_2, asum = 0, bsum = 0;
        for (int i = 0; i < 25; i++) {
            asum += acnt[i];
            bsum += bcnt[i];
            // 满足条件1或条件2的操作数：操作a的字母均小于等于字母i，操作b的字母均大于字母i，或者反之；
            // 注意不能计算字母为‘z’的情况，举例字符串是"a"和"aazz"
            ans_1 = Math.min(alen - asum + bsum, blen - bsum + asum);
            // 满足条件3的操作数：操作a和b中字母i以外的字母，令均转为i；
            ans_2 = Math.min(ans, alen - acnt[i] + blen - bcnt[i]);
            ans = Math.min(ans_1, ans_2);
        }
        // 计算条件3在字母为‘z’时的操作数，并比较；
        ans = Math.min(ans, alen - acnt[25] + blen - bcnt[25]);
        return ans;
    }
}
// @lc code=end
