/*
 * @lc app=leetcode.cn id=1025 lang=java
 *
 * [1025] 除数博弈
 */

// @lc code=start
class Solution {
    public boolean divisorGame(int n) {
        // 博弈
        return extracted(n);
    }

    /**
     * 40/40 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 23.83 % of java submissions (38.3 MB)
     * 
     * @param n
     * @return
     */
    private boolean extracted(int n) {
        return n % 2 == 0;
    }
}
// @lc code=end
