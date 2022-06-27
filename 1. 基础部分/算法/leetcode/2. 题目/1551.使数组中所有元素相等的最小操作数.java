/*
 * @lc app=leetcode.cn id=1551 lang=java
 *
 * [1551] 使数组中所有元素相等的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int n) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int x = 2 * i + 1;
            if (x > n) {
                ret += x - n;
            }
        }
        return ret;
    }
}
// @lc code=end
