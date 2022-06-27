/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // 采用位运算
        return n > 0 && (n & (n - 1)) == 0;

        // 朴素解法
        // return extracted(n);
    }

    /**
     * 朴素解法
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 35.87 % of java submissions (38.5 MB)
     * 
     * @param n
     * @return
     */
    private boolean extracted(int n) {
        if (n <= 0)
            return false;
        while (n % 2 == 0)
            n /= 2;
        return n == 1;
    }
}
// @lc code=end
