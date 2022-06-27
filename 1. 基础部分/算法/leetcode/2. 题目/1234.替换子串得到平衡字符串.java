import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1234 lang=java
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        // 滑动窗口
        // return extracted(s);

        // 统计每个单词的数目
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++;
        }
        int left = 0, right = 0;
        int ret = n;
        for (right = 0; right < n; right++) {
            // right会一个个的减去字符串，直到满足条件，left然后开始移动，收紧整个窗口
            count[s.charAt(right) - 'A']--;
            // 注意此处 left是小于 n（而不是小于right）;因为窗口最小可以为0，这个时候left是大于right的
            while (left < n && count['Q' - 'A'] <= n / 4
                    && count['W' - 'A'] <= n / 4
                    && count['E' - 'A'] <= n / 4
                    && count['R' - 'A'] <= n / 4) {
                ret = Math.min(ret, right - left + 1);
                count[s.charAt(left) - 'A']++;
                left++;
            }
        }
        return ret;

    }

    private int extracted(String s) {
        if (s == null || s.length() <= 0)
            return -1;
        int N = s.length();
        // 这里用26有的浪费,为了方便写代码,就这样吧
        int[] need = new int[26];
        // 初始化为-N/4这样最后得到的大于0的值就是多出来的
        Arrays.fill(need, -N / 4);
        int[] cur = new int[26];
        // 统计每个字符的出现次数
        for (int i = 0; i < N; i++) {
            need[s.charAt(i) - 'A']++;
        }
        // 有几个字符多出来了
        int needCount = 0;
        for (int i = 0; i < need.length; i++) {
            if (need[i] > 0)
                needCount++;
        }
        if (needCount == 0)
            return 0;
        int res = N;
        int left = 0, right = 0;
        int matchCount = 0;
        // 无脑套路滑窗
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need[c - 'A'] > 0) {
                cur[c - 'A']++;
                if (cur[c - 'A'] == need[c - 'A']) {
                    matchCount++;
                }
            }
            while (left <= right && matchCount == needCount) {
                res = Math.min(right - left + 1, res);
                char cl = s.charAt(left);
                if (need[cl - 'A'] > 0) {
                    cur[cl - 'A']--;
                    if (cur[cl - 'A'] < need[cl - 'A']) {
                        matchCount--;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
// @lc code=end
