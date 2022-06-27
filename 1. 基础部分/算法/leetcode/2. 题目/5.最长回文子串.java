/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // 中心扩展法 -- > 最优解
        return extracted(s);

        // 动态规划
        // return extracted2(s);


        
    }

    /**
     * Your runtime beats 35.43 % of java submissions
     * Your memory usage beats 24.88 % of java submissions (44.4 MB)
     * 
     * @param s
     * @return
     */
    private String extracted2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，
                // 此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private String extracted(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLen(s, i, i);
            int len2 = getLen(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                // start 从0位置开始截取，所以需要先-1，再除2
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // 截取字符需要是end+1
        return s.substring(start, end + 1);
    }

    private int getLen(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 因为是在left++ 和 right-- 之后，两个字符不相等，所以最终差值，要再减一
        return right - left - 1;
    }
}
// @lc code=end
