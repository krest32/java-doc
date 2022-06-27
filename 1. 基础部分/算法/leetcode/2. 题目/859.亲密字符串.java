/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        int len1 = s.length(), len2 = goal.length();
        if (len1 != len2)
            return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        // 统计两个字符串的字符否相同
        for (int i = 0; i < len1; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++;
            cnt2[b]++;
            if (a != b)
                sum++;
        }

        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            // 存在不同的字符放回false
            if (cnt1[i] != cnt2[i])
                return false;
            // 只有字符的数量超过2的时候，才能够交换字符
            if (cnt1[i] > 1)
                ok = true;
        }
        return sum == 2 || (sum == 0 && ok);
    }
}
// @lc code=end
