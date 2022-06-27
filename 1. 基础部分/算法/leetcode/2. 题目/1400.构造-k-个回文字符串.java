/*
 * @lc app=leetcode.cn id=1400 lang=java
 *
 * [1400] 构造 K 个回文字符串
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String s, int k) {
        // 右边界为字符串的长度
        int right = s.length();
        // 统计每个字符出现的次数
        int[] cnt = new int[26];
        for (int i = 0; i < right; ++i) {
            cnt[s.charAt(i) - 'a']++;
        }
        // 左边界为出现奇数次字符的个数
        int left = 0;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] % 2 == 1) {
                left++;
            }
        }
        // 注意没有出现奇数次的字符的特殊情况
        left = Math.max(left, 1);
        return left <= k && k <= right;

    }
}
// @lc code=end
