/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        // 位运算
        while (n != 0) {
            if ((n & 3) == 3 || (n & 3) == 0) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}
// @lc code=end
