/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 统计各位数字都不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // 数学 排列组合
        return method(n);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 30.14 % of java submissions (38.2 MB)
     * 
     * @param n
     * @return
     */
    int method(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}
// @lc code=end
