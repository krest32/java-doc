import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        // 动态规划
        // return extracted(p);

        return test(p);
    }

    private int test(String p) {
        // 记录到达该字符串，且以该字符结尾的字符串个数
        int[] dp = new int[26];
        int last = -1, max = 0;
        for (char ch : p.toCharArray()) {
            int cur = ch - 'a';
            if (last + 1 == cur || (last == 25 && cur == 0)) {
                max = max + 1;
            } else {
                max = 1;
            }

            if (max > dp[cur]) {
                dp[cur] = max;
            }
            last = cur;
        }
        return Arrays.stream(dp).sum();
    }

    /**
     * 81/81 cases passed (4 ms)
     * Your runtime beats 88.76 % of java submissions
     * Your memory usage beats 15.3 % of java submissions (41.5 MB)
     * 
     * @param p
     * @return
     */
    private int extracted(String p) {
        // 记录每一个字符
        int[] dp = new int[26];
        int last = -1, max = 0;
        // 依次遍历 p 中的字符
        char[] cs = p.toCharArray();
        for (char c : cs) {
            int cur = c - 'a';
            // 计算以当前字符为结尾的字符串的个数
            max = (cur == last + 1) || (last == 25 && cur == 0)
                    ? max + 1
                    : 1;
            // 记录当前元素可能的累加和
            if (max > dp[cur]) {
                dp[cur] = max;
            }
            // 记录上一个字符的字典序
            last = cur;
        }
        int ans = 0;
        for (int num : dp) {
            ans += num;
        }
        return ans;
    }
}
// @lc code=end
