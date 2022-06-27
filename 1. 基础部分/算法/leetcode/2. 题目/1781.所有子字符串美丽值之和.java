import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1781 lang=java
 *
 * [1781] 所有子字符串美丽值之和
 */

// @lc code=start
class Solution {
    public int beautySum(String s) {
        // 暴力
        return extracted(s);
    }

    private int extracted(String s) {
        int ans = 0;
        int len = s.length();
        char[] cs = s.toCharArray();
        int[][] freqs = new int[len + 1][26];
        int[] freq = new int[26];
        for (int i = 1; i <= len; i++) {
            int cur = cs[i - 1];
            freq[cur - 'a']++;
            freqs[i] = Arrays.copyOf(freq, 26);
        }
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j < i - 2; j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int[] freqi = freqs[i];
                int[] freqj = freqs[j];
                for (int k = 0; k < 26; k++) {
                    int sub = freqi[k] - freqj[k];
                    if (sub != 0) {
                        if (sub > max) {
                            max = sub;
                        }
                        if (sub < min) {
                            min = sub;
                        }
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
}
// @lc code=end
