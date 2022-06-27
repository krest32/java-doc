/*
 * @lc app=leetcode.cn id=1523 lang=java
 *
 * [1523] 在区间范围内统计奇数数目
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        if (high % 2 == 1) {
            high++;
        }
        return (high - low + 1) / 2;
    }
}
// @lc code=end
