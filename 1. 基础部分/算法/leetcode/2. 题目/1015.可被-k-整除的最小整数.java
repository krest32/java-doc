/*
 * @lc app=leetcode.cn id=1015 lang=java
 *
 * [1015] 可被 K 整除的最小整数
 */

// @lc code=start
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int temp = 1;
        int len = 1;
        while (temp % K != 0) {
            temp = temp % K;
            temp = temp * 10 + 1;
            len += 1;
        }
        return len;
    }
}
// @lc code=end
