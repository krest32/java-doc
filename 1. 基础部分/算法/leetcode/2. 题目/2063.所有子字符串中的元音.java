/*
 * @lc app=leetcode.cn id=2063 lang=java
 *
 * [2063] 所有子字符串中的元音
 */

// @lc code=start
class Solution {
    public long countVowels(String word) {
        // 如果 i 是元音， 那么包含它的子串的左
        // 端点可以选择 0, 1,⋯,i 一共 i+1 种

        // 动态规划 + 滚动数组
        // return extracted(word);

        // 普通动态规划
        return extracted2(word);
    }

    private long extracted2(String word) {
        int len = word.length();
        long[] dp = new long[len];
        long ans = 0;
        if (check(word.charAt(0))) {
            dp[0] = 1;
            ans += dp[0];
        }
        for (int i = 1; i < len; i++) {
            if (check(word.charAt(i))) {
                dp[i] = dp[i - 1] + i + 1;
            } else {
                dp[i] = dp[i - 1];
            }
            ans += dp[i];
        }
        return ans;
    }

    private long extracted(String word) {
        int len = word.length();
        long dp = 0;
        long ans = 0;
        if (check(word.charAt(0))) {
            dp = 1;
            ans += dp;
        }
        for (int i = 1; i < len; i++) {
            /**
             * 如果i位置是元音
             * 那么这个字符有i种不同的位置
             * +1 因为原有的元音，可以组成新长度的字符串
             */
            if (check(word.charAt(i))) {
                dp += i + 1;
            }
            /**
             * 前面每个字符的“最大长度子串”的元音字符数量不变。
             * 直接加入这个数量即可（因为新加入字符使得这些子串，
             * 作为新串的一部分被遍历到了
             */
            ans += dp;
        }
        return ans;
    }

    private boolean check(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
// @lc code=end
