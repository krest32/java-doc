/*
 * @lc app=leetcode.cn id=2177 lang=java
 *
 * [2177] 找到和为给定整数的三个连续整数
 */

// @lc code=start
class Solution {
    public long[] sumOfThree(long num) {
        // 除不开的话不可能相等
        if (num % 3 != 0) {
            return new long[0];
        }

        long x = num / 3 - 1;
        return new long[] { x, x + 1, x + 2 };
    }
}
// @lc code=end
