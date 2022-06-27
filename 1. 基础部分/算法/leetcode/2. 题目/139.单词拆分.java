import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 动态规划
        // 假设 dp[i] 表示0~i的字符串可以被分割出来
        return extracted(s, wordDict);
    }

    /**
     * Your runtime beats 62.97 % of java submissions
     * Your memory usage beats 31.56 % of java submissions (41.5 MB)
     * 
     * @param s
     * @param wordDict
     * @return
     */
    private boolean extracted(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
// @lc code=end
